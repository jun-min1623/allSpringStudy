package pilot.securitymybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pilot.securitymybatis.AccountRepo;
import pilot.securitymybatis.dto.PostLoginReq;
import pilot.securitymybatis.dto.PostLoginRes;
import pilot.securitymybatis.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;
    private final AuthenticationManager authenticationManager;

    public AccountServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public PostLoginRes login(PostLoginReq loginReq){
        // 기존 로그인 코드;
//        User user = accountRepo.selectAllUserInfoByUserId(loginReq.getUser_id());
//        if (user.getPwd().equals(loginReq.getPwd())) {
//            System.out.println("login Success!!");
//            return new PostLoginRes(true);
//        }
//        return new PostLoginRes(false);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginReq.getUser_id(),loginReq.getPwd())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("authentication.getPrincipal()"+authentication.getPrincipal());
        return (PostLoginRes) authentication.getPrincipal();
    }



}
