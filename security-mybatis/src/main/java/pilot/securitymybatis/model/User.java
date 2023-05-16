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
    private String role;

    public String getUser_id() {
        return user_id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public User(String user_id, String pwd, String email, String name, String role) {
        this.user_id = user_id;
        this.pwd = pwd;
        this.email = email;
        this.name = name;
        this.role = role;
    }
}
