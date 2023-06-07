package pilot.securitymybatis.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin().disable();
        http.httpBasic().disable();

        http.authorizeHttpRequests()
                .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/seller/**").hasRole("SELLER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll();
//        http.addFilterBefore(new JwtFi)

        //권한 실패 차리 로직 필요
        return http.build();
    }

}
