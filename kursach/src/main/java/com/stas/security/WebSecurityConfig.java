package com.stas.security;

import com.stas.CRUD;
import com.stas.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CRUD crud;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/authorization").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/authorization")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/icon/**");
    }

    @Bean
    public UserDetailsService userDetailsService() {
        List<com.stas.entity.Account> accList = crud.getAllAccounts();
        @Deprecated
        User.UserBuilder acc = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        for (int i = 0; i < crud.getAllAccounts().size(); i++)
            manager.createUser(acc
                    .username(accList.get(i).getLogin())
                    .password(accList.get(i).getPassword())
                    .roles().build());
        return manager;

    }
}