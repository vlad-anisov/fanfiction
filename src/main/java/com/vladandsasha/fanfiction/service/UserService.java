package com.vladandsasha.fanfiction.service;

import com.vladandsasha.fanfiction.repository.UserRepository;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public String addUser(User user, Model model){
        if(!checkUserAndPassword(user) || userRepository.findByUsername(user.getUsername()) != null){
            model.addAttribute("message", "User exists");
            return "signup";
        }
        else {
            addNewUser(user);
            return "redirect:/login";
        }
    }

    private void addNewUser(User user){
        userRepository.save(user);
        sendActivateCode(user);
    }

    private void sendActivateCode(User user){
        String message = String.format("Hello %s! \n Welcome to Fanfiction." +
                " Activate code https://vlad-and-sasha-fanfiction.herokuapp.com/activate/%s",user.getUsername(),user.getActivationCode());
        mailSender.send(user.getEmail(),"Activation code", message);
    }

    private boolean checkUserAndPassword(User user){
        if(user.getUsername() != null || user.getPassword() != null)
            return true;
        else
            return false;
    }

    public void activateUser(String code, Model model) {
        User user = userRepository.findByActivationCode(code);
        if(user == null)
            model.addAttribute("message","Activated code is note found");
        else {
            user.setActive(true);
            user.setActivationCode(null);
            userRepository.save(user);
            model.addAttribute("message","User successfully activated");
        }
    }
}
