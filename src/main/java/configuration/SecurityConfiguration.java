package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
    @Autowired
    UserDetailsService userDetailsService;
    
    
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
    	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
    	
    	auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider);
    }
    
   
    protected void configure(HttpSecurity http) throws Exception {
    	http
		.authorizeRequests()
		.antMatchers("/home","/login","/register","/product/**").permitAll()
		.antMatchers("/admin").hasAnyAuthority("ADMIN")
		.antMatchers("/hr").hasAnyAuthority("ADMIN","USER")
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.loginPage("/login")
		.passwordParameter("pass").usernameParameter("email")
		.defaultSuccessUrl("/home")
		.failureUrl("/login?error")
		.and().csrf()
		.and().httpBasic();
    	
    }
    
  
}
