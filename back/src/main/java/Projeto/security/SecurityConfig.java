package Projeto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSec) throws Exception {
        httpSec.csrf().disable()
                .authorizeHttpRequests((authz) -> authz
                        //.anyRequest(HttpMethod.GET, "/usuarios").permitAll()
                        .anyRequest().authenticated());
                //)
                //.httpBasic(withDefaults());
        return httpSec.build();
    }

}
