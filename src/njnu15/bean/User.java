package njnu15.bean;

public class User {
    private String UserId;
    private String Password;

    public String getUserId(){
        return UserId;
    }

    public String getPassword(){
        return Password;
    }

    public void setUserId(String UserId){
        this.UserId=UserId;
    }

    public void setPassword(String Password){
        this.Password=Password;
    }
}
