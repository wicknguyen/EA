package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("admin").password("{noop}admin").roles("USER","ADMIN").and()
//            .withUser("user").password("{noop}user").roles("USER");
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select username, password, 1 from user where username=?")
                .authoritiesByUsernameQuery("select u.username, r.name from user u inner join user_authority ur on(u.id=ur.user_id) inner join authority r on(ur.authority_id=r.id) where u.username=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());
    }

    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests().antMatchers(HttpMethod.GET, "/books").hasRole("USER").and()
        .authorizeRequests().antMatchers(HttpMethod.GET, "/books/*").hasRole("ADMIN").and()
        .authorizeRequests().antMatchers(HttpMethod.POST).hasRole("ADMIN").and()
    	.formLogin().permitAll().and()
    	.logout();
    }

    @Override
	public void configure(WebSecurity web) throws Exception {
		web.debug(true);
	}

}
