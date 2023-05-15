package pilot.securitymybatis.service;

import pilot.securitymybatis.dto.PostLoginReq;
import pilot.securitymybatis.dto.PostLoginRes;
import pilot.securitymybatis.model.User;

public interface AccountService {
    PostLoginRes login(PostLoginReq loginReq);
}
