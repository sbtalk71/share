package com.demo.spring;

/*import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
*/
//@Configuration
/*@EnableWebSecurity
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource datasource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/index").permitAll().antMatchers("/reg**").hasRole("USER")
				.antMatchers("/find**").hasRole("USER").and().formLogin().and().csrf().disable();
	}

	
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception{
	 * auth.inMemoryAuthentication().withUser("pavan").password(passwordEncoder()
	 * .encode("welcome1")).roles("USER");
	 * auth.inMemoryAuthentication().withUser("john").password(passwordEncoder()
	 * .encode("welcome1")).roles("ADMIN");
	 * auth.inMemoryAuthentication().withUser("scott").password(passwordEncoder()
	 * .encode("welcome1")).roles("USER");
	 * auth.inMemoryAuthentication().withUser("kirthi").password(passwordEncoder()
	 * .encode("welcome1")).roles("USER").disabled(true); }
	 

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource)
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
*/