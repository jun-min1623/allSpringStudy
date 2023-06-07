package pilot.securitymybatis.security.provider;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private String secretKey = "jwtsecretkey";
    private long tokenValidationMillsecond = 604800000;
    public String createToken(Long userId, List<String> roles){
        Claims claims = Jwts.claims().setSubject(Long.toString(userId));
        claims.put("roles", roles);
        Date now=  new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+tokenValidationMillsecond))
                .signWith(SignatureAlgorithm.ES256, secretKey)
                .compact();
    }

}
