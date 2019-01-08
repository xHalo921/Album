package njnu15.bean;

public class User {
    private String UserId;
    private String Password;
    private String gender;
    private boolean Permission;

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

    public boolean isPermission() {
        return Permission;
    }

    public void setPermission(boolean permission) {
        Permission = permission;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
