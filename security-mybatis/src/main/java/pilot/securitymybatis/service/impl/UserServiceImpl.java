package pilot.securitymybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pilot.securitymybatis.UserRepo;
import pilot.securitymybatis.model.User;
import pilot.securitymybatis.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;


    @Override
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @Override
    public void insertUserData(User user) {
        userRepo.insertUserData(user);
    }
}
