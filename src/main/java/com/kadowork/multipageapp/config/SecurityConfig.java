package com.kadowork.multipageapp.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.*;
import org.springframework.security.web.savedrequest.*;
import org.springframework.security.web.util.matcher.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // ログイン時 'continue' というクエリパラメータが付与されてしまうため
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);

        http.authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/public", "/public/*").permitAll()
                    .anyRequest().authenticated())
            .oauth2Login(Customizer.withDefaults())
            .requestCache((cache) -> cache
                    .requestCache(requestCache));
        // ログアウト未実装
//            .logout()
//            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//            .logoutSuccessUrl("http://localhost:8080/auth/realms/demo/protocol/openid-connect/logout?redirect_uri=http://localhost:8081/home");

        return http.build();
    }
}
