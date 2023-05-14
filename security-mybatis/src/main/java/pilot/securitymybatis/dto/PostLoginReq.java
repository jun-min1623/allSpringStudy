package pilot.securitymybatis.dto;

public class PostLoginReq {
    private String user_id;
    private String pwd;

    public PostLoginReq(String user_id, String pwd) {
        this.user_id = user_id;
        this.pwd = pwd;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getPwd() {
        return pwd;
    }
}
