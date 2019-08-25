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

    private final static String staticResource = "/resources/**";
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
                .antMatchers(staticResource).permitAll()
//                .antMatchers("/farfaraway").hasRole("CUSTOMER")
//                .antMatchers("/holiday/**").permitAll()
                .antMatchers("/customer/**").permitAll()
                .antMatchers("/intro").permitAll()
//                .antMatchers("/customer/showCustomerForm").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/main/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/intro")
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
