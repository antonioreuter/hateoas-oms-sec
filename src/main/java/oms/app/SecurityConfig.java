package oms.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
 
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select user_name, password, enabled from users where user_name = ?")
			.authoritiesByUsernameQuery("select u.user_name, r.role from roles r, users u where u.user_id = r.user_id and u.user_name = ?");
	}

	@Override
	protected void configure(HttpSecurity httpSec) throws Exception {
		httpSec
			.authorizeRequests()
			.antMatchers("/healthcheck").permitAll()
			.antMatchers("/api/users").hasRole("ADMIN")
			.antMatchers("/api/**").hasAnyRole("USER", "ADMIN")
			.anyRequest().authenticated()
			.and()
			.httpBasic();
	}

}
