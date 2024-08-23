package com.scm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class securityConfig {
    //user create and login using memory service wether user present in memory
    //@Bean
    //public UserDetailsManager userDetailsManager(){

        //with roles you can define which paths that it can access
        // UserDetails user1 =  User.withDefaultPasswordEncoder().username("admin123").password("admin123").roles("ADMIN").build();
        // UserDetails user2 =  User.withUsername("admin1234").password("admin1234").build();

        // var inMemoryUserDetailManager = new InMemoryUserDetailsManager(user1,user2);

        // return inMemoryUserDetailManager;
    //}

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        //userdetail service object
        daoAuthenticationProvider.setUserDetailsService(null);
        //password encoder object
       daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
