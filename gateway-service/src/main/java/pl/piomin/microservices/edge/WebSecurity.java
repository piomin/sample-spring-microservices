package pl.piomin.microservices.edge;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter   {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.antMatcher("/**")
        .authorizeRequests()
        .anyRequest()
        .authenticated();
	}
	
}
