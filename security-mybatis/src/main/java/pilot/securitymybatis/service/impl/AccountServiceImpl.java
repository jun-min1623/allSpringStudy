package pilot.securitymybatis.service.impl;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pilot.securitymybatis.AccountRepo;
import pilot.securitymybatis.dto.PostLoginReq;
import pilot.securitymybatis.dto.PostLoginRes;
import pilot.securitymybatis.model.User;
import pilot.securitymybatis.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;

    @Override
    public PostLoginRes login(PostLoginReq loginReq){
        // login 인증관련은 시큐리티 강의보면서 공부;
        User user = accountRepo.selectAllUserInfoByUserId(loginReq.getUser_id());
        if (user.getPwd().equals(loginReq.getPwd())) {
            System.out.println("login Success!!");
            return new PostLoginRes(true);
        }
        return new PostLoginRes(false);

    }


}
