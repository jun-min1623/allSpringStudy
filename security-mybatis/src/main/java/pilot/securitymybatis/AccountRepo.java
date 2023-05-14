package pilot.securitymybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountRepo {
    @Select("select * from users where user_id = #{user_id}")
    public Object find(String user_id);
}
