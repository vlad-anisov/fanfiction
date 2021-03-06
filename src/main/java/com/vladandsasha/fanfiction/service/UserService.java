package com.vladandsasha.fanfiction.service;

import com.vladandsasha.fanfiction.repository.UserRepository;
import com.vladandsasha.fanfiction.users.Role;
import com.vladandsasha.fanfiction.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSender mailSender;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${hostname}")
    private String hostname;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public String addUser(User user, Model model){
        if(userRepository.findByUsername(user.getUsername()) != null ||
                userRepository.findByEmail(user.getEmail()) != null){
            model.addAttribute("message", false);
            return "signup";
        }
        else {
            addNewUser(user);
            return "redirect:/login";
        }
    }

    private void addNewUser(User user){
        user.setDarkMode(false);
        user.setActive(false);
        user.setActivationCode(UUID.randomUUID().toString());
        user.setRole(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        sendActivateCode(user);
    }

    private void sendActivateCode(User user){
        String message = String.format("Hello %s! \n Welcome to Fanfiction." +
                " Activate code %s/activate/%s",user.getUsername(), hostname, user.getActivationCode());
        mailSender.send(user.getEmail(),"Activation code", message);
    }

    public void activateUser(String code, Model model) {
        User user = userRepository.findByActivationCode(code);
        if(user == null)
            model.addAttribute("message",false);
        else {
            user.setActive(true);
            user.setActivationCode(null);
            userRepository.save(user);
            model.addAttribute("message",true);
        }
    }

    public void changeUser(String username, String newUsername, boolean darkMode, User user){
        User userEdit = userRepository.findByUsername(username);
        userEdit.setUsername(newUsername);
        userEdit.setDarkMode(darkMode);
        userRepository.save(userEdit);
        if(user.getUsername().equals(username)) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(userEdit, userEdit.getPassword(), userEdit.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
}
