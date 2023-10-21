package com.example.crm.security;

import com.example.crm.views.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity https) throws Exception {
        super.configure(https);
        setLoginView(https, LoginView.class);
    }


    @Bean
    UserDetailsManager userDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("pavlo")
                        .password("{noop}pavlo1441*")
                        .roles("USER").build()
        );
    }
}
