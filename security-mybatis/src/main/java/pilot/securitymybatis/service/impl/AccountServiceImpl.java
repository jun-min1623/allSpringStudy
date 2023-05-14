package pilot.securitymybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pilot.securitymybatis.AccountRepo;
import pilot.securitymybatis.dto.PostLoginReq;
import pilot.securitymybatis.dto.PostLoginRes;
import pilot.securitymybatis.service.AccountService;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;

    private UserDetails userDetails;

    @Override
    public PostLoginRes login(PostLoginReq loginReq) {
        // login 인증관련은 시큐리티 강의보면서 공부;
        //     userDetails.
        return new PostLoginRes(true);
    }
}
