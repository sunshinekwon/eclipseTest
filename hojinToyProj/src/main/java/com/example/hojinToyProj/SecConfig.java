package com.example.hojinToyProj;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.hojinToyProj.main.AuthSuccess;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeHttpRequests()
			.antMatchers("/test").permitAll()
			.antMatchers("/loginP").permitAll()
			.anyRequest()
			.authenticated()
		.and()
		.formLogin()
			.loginPage("/loginP")
			.loginProcessingUrl("/loginProc")
			.usernameParameter("id")
			.passwordParameter("pw")
			.successHandler(new AuthSuccess());
		}
	
	
}
