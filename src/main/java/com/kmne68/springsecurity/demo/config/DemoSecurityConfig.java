package com.kmne68.springsecurity.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	//	UserBuilder users = User.withDefaultPasswordEncoder();
		
		/*
		auth.inMemoryAuthentication()
		.withUser("Gandalf").password("test123").roles("Grey Wizard");
		
		auth.inMemoryAuthentication()
		.withUser("Saruman").password("test123").roles("White Wizard");
		
		auth.inMemoryAuthentication()
		.withUser("Radagast").password("test123").roles("Brown Wizard");
		*/
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("Gandalf").password("test123").roles("Grey Wizard", "White Wizard"))
		.withUser(users.username("Saruman").password("test123").roles("White Wizard"))
		.withUser(users.username("Radagast").password("test123").roles("Brown Wizard"));
		
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/").hasRole("Brown Wizard")
		.antMatchers("/").hasRole("White Wizard")
		.antMatchers("/leaders/**").hasRole("Grey Wizard")
		.and()
		.formLogin()
		.loginPage("/showLoginPage")
		.loginProcessingUrl("/authenticateUser")
		.permitAll()
		.and()
		.logout().permitAll();
		
	}

	
	
}
