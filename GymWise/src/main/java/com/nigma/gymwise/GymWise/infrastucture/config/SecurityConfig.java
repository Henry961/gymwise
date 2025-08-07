package com.nigma.gymwise.GymWise.infrastucture.config;

import com.nigma.gymwise.GymWise.infrastucture.jwt.JWTAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    public SecurityConfig(JWTAuthorizationFilter jwtAuthorizationFilter) {
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/user/save").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/user/**").hasAnyRole("1", "2")
                        .requestMatchers("/api/user/**", "/api/rol/**", "/api/membershiptype/**", "/api/typedocument/**").hasRole("1")
                        .requestMatchers(HttpMethod.GET, "/api/exercise/**", "/api/exercisemachine/**", "/api/exercisemachinerelation/**").hasAnyRole("1", "2", "3")
                        .requestMatchers("/api/exercise/**", "/api/exercisemachinerelation/**", "/api/exercisemachine/**").hasAnyRole("1", "2")
                        .requestMatchers(HttpMethod.GET, "/api/dietplan/**", "/api/dietmeal/**").hasAnyRole("1", "2", "3")
                        .requestMatchers("/api/dietplan/**", "/api/dietmeal/**").hasAnyRole("1", "2")
                        .requestMatchers(HttpMethod.GET, "/api/trainingrealized/**", "/api/trainingrecommend/**").hasAnyRole("1", "2", "3")
                        .requestMatchers("/api/trainingrealized/**", "/api/trainingrecommend/**").hasAnyRole("1", "2")
                        .requestMatchers("/api/userbody/findAll").hasAnyRole("1", "2")
                        .requestMatchers("/api/userpreferences/findAll").hasAnyRole("1", "2")
                        .requestMatchers("/api/usermeasures/findAll").hasAnyRole("1", "2")
                        .requestMatchers("/api/userbody/**").hasAnyRole("1", "2", "3")
                        .requestMatchers("/api/userpreferences/**").hasAnyRole("1", "2", "3")
                        .requestMatchers("/api/usermeasures/**").hasAnyRole("1", "2", "3")
                        .requestMatchers(HttpMethod.GET, "/api/userrecord/**").hasAnyRole("1", "2", "3")
                        .requestMatchers("/api/userrecord/**").hasAnyRole("1", "2")
                        .requestMatchers("/api/notification/**", "/api/feedback/**", "/api/iarecommendation/**").hasAnyRole("1", "2", "3")
                        .requestMatchers("/api/security/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
