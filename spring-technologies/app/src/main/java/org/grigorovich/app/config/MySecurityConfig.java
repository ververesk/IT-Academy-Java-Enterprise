package org.grigorovich.app.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder= User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("Veronika").password("1").roles("ADMIN"))
                .withUser(userBuilder.username("Elena").password("1").roles("TEACHER"))
                .withUser(userBuilder.username("Ivan").password("1").roles("STUDENT"));
    }

    @Override //делаем авторизацию
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/noahSmith").hasAnyRole("ADMIN","STUDENT")
                .antMatchers("/", "/allStudentsOfMath", "/saveMathCourse" ,"/updateMathCourse").hasAnyRole("ADMIN","TEACHER")
                .antMatchers("/**").hasRole("ADMIN")
                .and().formLogin().permitAll();
    }
}
