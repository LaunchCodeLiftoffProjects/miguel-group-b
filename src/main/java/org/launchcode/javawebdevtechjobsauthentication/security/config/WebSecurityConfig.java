package org.launchcode.javawebdevtechjobsauthentication.security.config;

//import org.launchcode.javawebdevtechjobsauthentication.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/bootstrap.css")
                .permitAll()
                .antMatchers("/css/techjobs.css")
                .permitAll()
                .antMatchers("/register2")
                .permitAll()
                .antMatchers("/view")
                .permitAll()
                .antMatchers("/register")
                .permitAll()
                .antMatchers("/fragments")
                .permitAll()
                .antMatchers("/models/Vendor")
                .permitAll()
                .antMatchers("/models/User")
                .permitAll()
                .antMatchers("/index")
                .permitAll()
                .antMatchers("/fragments")
                .permitAll()
                .antMatchers("/addVendor")
                .permitAll()
                .antMatchers("/api/v*/registration/**")
                .permitAll()
                .antMatchers("/login2")
                .permitAll()
                .anyRequest()
                .authenticated().and();
//                .formLogin()
//                .loginPage("/login2");

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }

//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider =
//                new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(bCryptPasswordEncoder);
//        provider.setUserDetailsService(appUserService);
//        return provider;
//    }
}
