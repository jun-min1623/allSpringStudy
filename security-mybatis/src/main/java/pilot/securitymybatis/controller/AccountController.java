package pilot.securitymybatis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pilot.securitymybatis.dto.PostLoginReq;
import pilot.securitymybatis.dto.PostLoginRes;
import pilot.securitymybatis.service.AccountService;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody PostLoginReq postLogInReq){
        PostLoginRes postLogInRes = accountService.login(postLogInReq);
        return new ResponseEntity<>(postLogInRes, HttpStatus.OK);

    }
}
