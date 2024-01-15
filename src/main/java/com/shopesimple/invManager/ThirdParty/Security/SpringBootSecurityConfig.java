package com.shopesimple.invManager.ThirdParty.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SpringBootSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/dashboard/product/get_products").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
//                        .anyRequest().permitAll()
                )
                        .oauth2ResourceServer((oauth2) ->
                                oauth2.jwt(Customizer.withDefaults()))
                        .oauth2ResourceServer(oauth2 -> {
                          try {
                              oauth2
                                    .jwt(jwt -> jwt
                                                   .jwtAuthenticationConverter(new CustomAuthJwtConverter())
                                         );

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        return http.build();
    }
}
