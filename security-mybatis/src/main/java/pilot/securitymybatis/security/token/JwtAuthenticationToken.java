package pilot.securitymybatis.security.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {


    private String jsonToken;
    private Object credentials;
    private Object principal;

    public JwtAuthenticationToken(Object credentials, Object principal) {
        super(null);
        setAuthenticated(false);
        this.credentials = credentials;
        this.principal = principal;
    }

    public JwtAuthenticationToken(String principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        setAuthenticated(true);
        this.principal = principal;
        this.credentials = credentials;
    }


    public String getJsonToken() {
        return this.jsonToken;
    }


    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}
