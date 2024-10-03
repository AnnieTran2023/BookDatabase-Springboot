package fi.haagahelia.bookdatabase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import fi.haagahelia.bookdatabase.web.UserDetailServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
        @Autowired
        private UserDetailServiceImpl userDetailsService;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .anyRequest().authenticated() // Require authentication for all requests
                                )
                                .formLogin(form -> form
                                                .loginPage("/login")
                                                .permitAll() // Allow everyone to see the login page
                                )
                                .logout(logout -> logout
                                                .permitAll() // Allow everyone to see the logout page
                                );

                return http.build();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }
}
