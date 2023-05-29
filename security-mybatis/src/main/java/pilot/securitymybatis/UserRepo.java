package pilot.securitymybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import pilot.securitymybatis.model.User;

import java.util.List;

@Mapper
@Repository
public interface UserRepo {
    @Select("select * from users")
    List<User> getAllUsers();

    @Insert("insert into users(user_id, pwd, email, name, roles) values (#{user_id},#{pwd},#{email},#{name},#{roles})")
    void insertUserData(User user);


}
