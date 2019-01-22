package com.test.everis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// @formatter:off
	
	
		PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
	 @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	          .withUser("admin").password("admin")
	          .authorities("ADMIN");
	        
	        auth.inMemoryAuthentication()
	          .withUser("user").password("user")
	          .authorities("USER");
	    }
	 
	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/resources/**");
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http
			.csrf().disable()
			.authorizeRequests().anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.and()
			.authorizeRequests().antMatchers("/home").hasRole("ADMIN")
			.and()
			.logout().deleteCookies("rememberme").permitAll()
			.and()
			.rememberMe().tokenValiditySeconds(60);
	    }
	    
	    @Bean
		public PasswordEncoder passwordEncoder() {
		    
		        return encoder;
		    
		}
	}

