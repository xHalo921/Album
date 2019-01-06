package njnu15.bean;

public class User {
    private String UserId;
    private String Psaaword;

    public String getUserId(){
        return UserId;
    }

    public String getPsaaword(){
        return Psaaword;
    }

    public void setUserId(String UserId){
        this.UserId=UserId;
    }

    public void setPsaaword(String Psaaword){
        this.Psaaword=Psaaword;
    }
}
