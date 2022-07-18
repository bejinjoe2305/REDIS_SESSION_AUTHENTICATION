package com.bejin.spring.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableRedisHttpSession
@Configuration
public class Config extends WebSecurityConfigurerAdapter {

   
	/*
	 * @Bean public UserDetailsService userDetailsService() {
	 * InMemoryUserDetailsManager userDetailsService = new
	 * InMemoryUserDetailsManager();
	 * 
	 * var user = User.withUsername("user") .password("password")
	 * .authorities("USER_ROLE") .build();
	 * 
	 * userDetailsService.createUser(user);
	 * 
	 * return userDetailsService; }
	 */

//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      //  auth.userDetailsService(userDetailsService());
        auth.inMemoryAuthentication()
        .withUser("user")
        .password("{noop}password")
        .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
            .and()
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest()
            .fullyAuthenticated();
    }
}