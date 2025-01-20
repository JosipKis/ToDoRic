package unizd.inoIT.todo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import unizd.inoIT.todo.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService USER_SERVICE;

    public SecurityConfig(UserService USER_SERVICE) {
        this.USER_SERVICE = USER_SERVICE;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.securityMatcher("/**").authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/css/**", "/js/**", "/images/**", "/register").permitAll();
                    authorize.anyRequest().authenticated();
                        }
                        
                ).formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/my-tasks")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(USER_SERVICE);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return USER_SERVICE;
    }
}
