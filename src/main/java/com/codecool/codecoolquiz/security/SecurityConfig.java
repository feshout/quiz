package com.codecool.codecoolquiz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AccessDeniedHandler accessDeniedHandler;
    private UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(AccessDeniedHandler accessDeniedHandler, UserDetailsService userDetailsService) {

        this.accessDeniedHandler = accessDeniedHandler;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/categories/**", "/questions/**").hasAuthority("admin")
                .antMatchers("/webjars/**", "/css/**", "/403", "/404", "/", "/user/new").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/")
                .and()
            .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        // auth.inMemoryAuthentication()
        //         .withUser("admin").password("admin").roles("ADMIN")
        //         .and()
        //         .withUser("user").password("user").roles("USER");
        auth.userDetailsService(userDetailsService);
    }

}