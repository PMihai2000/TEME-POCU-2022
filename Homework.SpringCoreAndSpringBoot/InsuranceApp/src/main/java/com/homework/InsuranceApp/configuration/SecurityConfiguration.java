package com.homework.InsuranceApp.configuration;


import com.homework.InsuranceApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final UserRepository userRepository;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .mvcMatchers("/api/users/details").hasAuthority("view")
                .mvcMatchers("/api/users/get").hasRole("dev")
                .mvcMatchers("/api/users/create").hasAuthority("create")
                .mvcMatchers("/api/users/remove").hasRole("dev")
                .mvcMatchers("/api/users/remove").hasAuthority("remove")

                .mvcMatchers("/api/insurances/details").hasAuthority("view")
                .mvcMatchers("/api/insurances/get").hasRole("dev")
                .mvcMatchers("/api/insurances/remove").hasRole("dev")
                .mvcMatchers("/api/insurances/remove").hasAuthority("remove")

                .mvcMatchers("/api/insurances/cars/create").hasAuthority("create")
                .mvcMatchers("/api/insurances/cars/insurancePrice").hasAuthority("view")

                .mvcMatchers("/api/insurances/houses/create").hasAuthority("create")
                .mvcMatchers("/api/insurances/houses/insurancePrice").hasAuthority("view")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        return httpSecurity.build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        var userDetailsManager = new InMemoryUserDetailsManager();

        List<com.homework.InsuranceApp.model.User> users = userRepository.findAll();

        for (var user:
             users) {

        }


        UserDetails user = User.withUsername("Baraca")
                .roles("dev")
                .password("123")
                .authorities("create","nope","delete")
                .build();

        userDetailsManager.createUser(user);


        return userDetailsManager;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
