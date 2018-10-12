package com.ldap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.ldapAuthentication()
				.userDnPatterns("uid={0},ou=Users")
				.userSearchBase("ou=Users")
				.userSearchFilter("uid={0}")
				.contextSource()
					.url("ldap://localhost:10389/dc=example,dc=com")
					.and()
				.passwordCompare()
					.passwordEncoder(passwordEncoder())
					.passwordAttribute("userPassword");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest()
					.fullyAuthenticated()
			.and()
				.formLogin();
	}

	@Bean
	public LdapShaPasswordEncoder passwordEncoder() {
		return new LdapShaPasswordEncoder();
	}
	
}
