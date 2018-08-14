package top.mcwebsite.security.exception;

/**
 * @time 18-7-25 下午2:21
 * @auther mengchen
 */
public class UserNotExistException extends RuntimeException{

    private String id;


    public UserNotExistException(String id) {
        super("User not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
