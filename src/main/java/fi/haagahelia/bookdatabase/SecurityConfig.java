package fi.haagahelia.bookdatabase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

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

        @Bean
        public UserDetailsService userDetailsService() {
                List<UserDetails> users = new ArrayList<UserDetails>();
                PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

                UserDetails user1 = User.withUsername("user").password(passwordEncoder.encode("user")).roles("USER")
                                .build();
                UserDetails user2 = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("ADMIN")
                                .build();

                users.add(user1);
                users.add(user2);

                return new InMemoryUserDetailsManager(users);
        }
}
