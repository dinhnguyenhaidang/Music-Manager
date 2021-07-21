package com.musicmanager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configures Spring Security
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-21
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/music-manager/album/**").hasAnyRole("ADMIN", "USER")
				.antMatchers("/music-manager/singer").hasRole("ADMIN")
				.antMatchers("music-manager/song").hasRole("ADMIN")
				.antMatchers("/").permitAll()
				.and().formLogin();
//		http.authorizeRequests()
//				.antMatchers("/admin").hasRole("ADMIN")
//				.antMatchers("/user").hasAnyRole("ADMIN", "USER")
//				.antMatchers("/").permitAll()
//				.and().formLogin();
	}

	/**
	 * Use NoOpPasswordEncoder for now
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
