package pilot.securitymybatis.dto;

public class PostLoginRes {
    private boolean success;

    public PostLoginRes(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
