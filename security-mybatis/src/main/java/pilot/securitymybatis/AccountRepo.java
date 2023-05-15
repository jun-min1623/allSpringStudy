package pilot.securitymybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import pilot.securitymybatis.model.User;

@Mapper
@Repository
public interface AccountRepo {
    @Select("select user_id,pwd,email,name from users where user_id = #{user_id}")
    User selectAllUserInfoByUserId(String user_id);
}
