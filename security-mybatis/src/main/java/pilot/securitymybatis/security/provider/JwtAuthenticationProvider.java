package pilot.securitymybatis.security.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import pilot.securitymybatis.AccountRepo;
import pilot.securitymybatis.dto.PostLoginReq;
import pilot.securitymybatis.dto.PostLoginRes;
import pilot.securitymybatis.security.token.JwtAuthenticationToken;
import pilot.securitymybatis.service.AccountService;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private AccountService accountService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            JwtAuthenticationToken authenticationToken = (JwtAuthenticationToken) authentication;
            Object principal = authenticationToken.getPrincipal();
            Object credential = authenticationToken.getCredentials();
            PostLoginRes postLoginRes = accountService.login(new PostLoginReq((String) principal, (String) credential));
            if (postLoginRes.isSuccess()){
                JwtAuthenticationToken authenticated = new JwtAuthenticationToken((String) principal, null, AuthorityUtils.createAuthorityList("ROLE_USER"));
                authenticated.setDetails(postLoginRes);
                return authenticated;
            }



        }catch (IllegalArgumentException e){
            throw new BadCredentialsException(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
