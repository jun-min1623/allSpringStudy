package pilot.securitymybatis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User {

    private String user_id;
    private String pwd;
    private String email;
    private String name;

    public String getUser_id() {
        return user_id;
    }

    public String getPassword() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public User(String user_id, String pwd, String email, String name) {
        this.user_id = user_id;
        this.pwd = pwd;
        this.email = email;
        this.name = name;
    }


}
