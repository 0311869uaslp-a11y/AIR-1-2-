package com.ecoalis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Formato CORRECTO para Spring Security 4
        auth.inMemoryAuthentication()
            .withUser("user").password("password").roles("USER")
            .and()
            .withUser("admin").password("admin").roles("DIRECTION", "USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // PasswordEncoder que NO codifica (solo para desarrollo)
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login", "/resources/**").permitAll()
                .antMatchers("/ddc/direction").hasRole("DIRECTION")
                .antMatchers("/ddc/**").authenticated()
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .loginPage("/login")  
                .loginProcessingUrl("/perform_login")  
                .defaultSuccessUrl("/ddc/home", true)
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/perform_logout")  
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
                .and()
            .csrf().disable();  // IMPORTANTE: desactivar temporalmente
    }
}