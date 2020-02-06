//
//package ver.badminton.helper;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
////import meralco.rtp.helper.Config;
///**
// *
// *
// * @author supray
// **/
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//    auth.inMemoryAuthentication().withUser("MERALCOBRPT").password("{noop}password").roles("USER");
//
//  }
//
//  // Secure the endpoins with HTTP Basic authentication
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//
//    // HTTP Basic authentication
//    http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/**").hasRole("USER").and().csrf().disable()
//        .formLogin().disable();
//  }
//
//}
