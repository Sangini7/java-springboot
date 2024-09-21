package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(customizer-> customizer.disable())//disable csrf
        .authorizeHttpRequests(request->request.anyRequest().authenticated()) //ensure security is enable for all the req
        .httpBasic(Customizer.withDefaults())// for postman
        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));// with every request login is needed

        return http.build();

    }

}
