package com.vladandsasha.fanfiction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import java.net.URISyntaxException;

@SpringBootApplication
public class FanfictionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanfictionApplication.class, args);
    }

}
