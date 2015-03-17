package oms.app;

import javax.sql.DataSource;

import oms.model.api.RoleEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select login, password, enabled from users where login = ?")
			.authoritiesByUsernameQuery("select u.login, r.role from roles r, users u where u.user_id = r.user_id and u.login = ? and u.enabled = 1")
			.passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity httpSec) throws Exception {
		httpSec
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/healthcheck").hasRole(RoleEnum.USER.name())
			.antMatchers("/api/users").hasRole(RoleEnum.ADMIN.name())
			.antMatchers("/api/**").hasAnyRole(	RoleEnum.USER.name(), 
												RoleEnum.SELLER.name(), 
												RoleEnum.CUSTOMER_SERVICE.name(), 
												RoleEnum.ADMIN.name())
			.and()
			.httpBasic()
			.and()
			.requiresChannel()
			.anyRequest().requiresSecure();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		if (encoder == null) {
			encoder = new BCryptPasswordEncoder(12);
		}
		
		return encoder;
	}

}
