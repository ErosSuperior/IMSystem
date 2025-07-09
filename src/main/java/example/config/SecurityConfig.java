package example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


    @Configuration
    public class SecurityConfig {
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable())
                    .formLogin(form -> form.disable())
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers(
                                    "/login",
                                    "/register",
                                    "/home",
                                    "/css/**",
                                    "/js/**",
                                    "/assets/**",
                                    "/api/interview-results",
                                    "/api/interview-results/add",           // POST from form
                                    // Web Controller: hiển thị form thêm
                                    "/interview-results/form",
                                    "/controller/interview-results",
                                    "/interview-results/**",
                                    "/controller/interview-results/**",
                                    "/**"
                            ).permitAll()
                            .anyRequest().authenticated()
                    )
                    .logout(logout -> logout
                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/login?logout")
                            .permitAll()
                    );

            return http.build();
        }

    }
