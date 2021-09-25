package org.launchcode.snapsnap.users;



import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**").permitAll()
                .antMatchers("/delete/**", "/products/**").hasAuthority("ADMIN")
                .antMatchers("/addMenu/**").hasAnyAuthority("ADMIN", "VENDOR")
                .antMatchers("/menu/addProducts/**").hasAnyAuthority("ADMIN", "VENDOR")
                .antMatchers("/view/**").hasAnyAuthority("USER", "ADMIN", "VENDOR")
                .antMatchers("/index/**").hasAnyAuthority("USER", "ADMIN", "VENDOR")
                .antMatchers("/cart/**").hasAnyAuthority("USER", "ADMIN", "VENDOR")
                .antMatchers("/products/add/*").hasAnyAuthority("ADMIN", "VENDOR")
                .antMatchers("/addToCart/**").hasAnyAuthority("USER", "ADMIN", "VENDOR")
                .antMatchers("/register/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                ;

    }
}
