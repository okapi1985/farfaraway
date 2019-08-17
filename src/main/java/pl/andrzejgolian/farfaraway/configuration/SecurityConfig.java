package pl.andrzejgolian.farfaraway.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.andrzejgolian.farfaraway.role.CustomCustomerDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();
    private final CustomCustomerDetailsService customCustomerDetailsService;

    public SecurityConfig(CustomCustomerDetailsService customCustomerDetailsService) {
        this.customCustomerDetailsService = customCustomerDetailsService;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(customCustomerDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/farfaraway").permitAll()
//                .antMatchers("/customer/createCustomer").permitAll()
                .antMatchers("/customer/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/main/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/farfaraway")
                .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin);
//    }
}
