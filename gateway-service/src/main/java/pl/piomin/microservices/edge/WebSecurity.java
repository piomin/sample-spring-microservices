package pl.piomin.microservices.edge;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.bind.annotation.SessionAttributes;

@Configuration
@SessionAttributes("authorizationRequest")
public class WebSecurity extends WebSecurityConfigurerAdapter   {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		super.configure(http);
//	    http.antMatcher("/**")
//        .authorizeRequests()
//        .anyRequest().permitAll();
//        .authenticated();
//		http.authorizeRequests().anyRequest().authenticated()
//        .and()
//        .httpBasic().and().csrf().disable();
//		http.csrf().disable();
	}
	
}
