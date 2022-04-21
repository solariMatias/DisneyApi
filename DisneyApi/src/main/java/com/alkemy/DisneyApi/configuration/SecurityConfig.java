package com.alkemy.DisneyApi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.alkemy.DisneyApi.security.CustomUserDetailsService;
import com.alkemy.DisneyApi.security.JwtAuthenticationEntryPoint;
import com.alkemy.DisneyApi.security.JwtAuthenticationFilter;

@Configuration	
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsSrvc;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthEntryPoint;
	
	@Bean
	public JwtAuthenticationFilter authFilter() {
		return new JwtAuthenticationFilter();
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.exceptionHandling()
			.authenticationEntryPoint(jwtAuthEntryPoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
		    .authorizeRequests()
		    	.antMatchers(HttpMethod.GET,"/characters/*").hasRole("ADMIN")
		    	.antMatchers(HttpMethod.POST,"/characters/*").hasRole("ADMIN")
		    	.antMatchers(HttpMethod.PUT,"/characters/*").hasRole("ADMIN")
		    	
		    	
		    	.antMatchers(HttpMethod.GET,"/movies/*").hasRole("ADMIN")
		    	.antMatchers(HttpMethod.POST,"/movies/*").hasRole("ADMIN")
		    	.antMatchers(HttpMethod.PUT,"/movies/*").hasRole("ADMIN")
		    	.antMatchers(HttpMethod.DELETE,"/movies/*").hasRole("ADMIN")
		    	
		    	.antMatchers(HttpMethod.GET,"/genres/*").hasRole("ADMIN")
		    	.antMatchers(HttpMethod.POST,"/genres/*").hasRole("ADMIN")
		    	
		    	.antMatchers(HttpMethod.POST,"/auth/**").permitAll()

		    .anyRequest()
		    .authenticated();
		http.addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsSrvc).passwordEncoder(passwordEncoder());
	}
	
	
}
