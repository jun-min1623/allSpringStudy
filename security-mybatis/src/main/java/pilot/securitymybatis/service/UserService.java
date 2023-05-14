package pilot.securitymybatis.service;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;
import pilot.securitymybatis.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    public void insertUserData(User user);

}
