package com.ethereum.web3j;

import com.ethereum.web3j.domains.security.Authority;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author I.T.W764
 */
@Configuration
@EnableWebSecurity
//@EnableJpaRepositories("com.ethereum.web3j.domains.repos")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  public static final Authority AUTHORITY_SU_ADMIN = new Authority("ADMIN");
  public static final Authority AUTHORITY_CLIENT = new Authority("CLIENT");

  @Bean(name = "passwordEncoder")
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

//  @Resource(name = "springSecUserDetailsServiceImpl")
//  @Autowired
//  private UserDetailsService userDetailsService;
//  
//  @Bean
//  public DaoAuthenticationProvider daoAuthenticationProvider() {
//    DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
//    daoAuth.setUserDetailsService(userDetailsService);
//    daoAuth.setPasswordEncoder(passwordEncoder());
//    return daoAuth;
//  }
//  
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.authenticationProvider(daoAuthenticationProvider());
//  }
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().permitAll();
//    http
//            .authorizeRequests().antMatchers("/rest/**").permitAll()
//            .and().authorizeRequests().antMatchers("/wallet").permitAll().anyRequest().authenticated()
//            .and().authorizeRequests().antMatchers("/wallet/**").permitAll().anyRequest().authenticated()
//            .and().authorizeRequests().antMatchers("/admin/**").hasAuthority(AUTHORITY_SU_ADMIN.getAuthority())//hasRole(ROLE_ADMIN.getRole()).anyRequest().authenticated()
//            ;

//    http.csrf().ignoringAntMatchers("/h2/**", "/h2-console/**");//.disable();
//    http.headers().frameOptions().disable();
  }

//  @Bean
//  @Override
//  public UserDetailsService userDetailsService() {
//    UserDetails user
//            = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password("pass")
//            .roles("CLIENT")
//            .authorities("CLIENT")
//            .build();
//    
//    return new InMemoryUserDetailsManager(user);
//  }
}
