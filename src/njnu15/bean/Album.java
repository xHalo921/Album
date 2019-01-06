package njnu15.bean;

import java.util.Date;

public class Album {
    private int AlbumId;
    private String AlbumName;
    private String UserId;
    private String category;
    private Date CreateTime;

    public int getAlbumId(){
        return AlbumId;
    }
    public void setAlbumId(int AlbumId){
        this.AlbumId=AlbumId;
    }

    public String getAlbumName(){
        return AlbumName;
    }
    public void setAlbumName(String AlbumName){
        this.AlbumName=AlbumName;
    }

    public String getUserId(){
        return UserId;
    }
    public void setUserId(String UserId){
        this.UserId=UserId;
    }

    public String getcategory(){
        return category;
    }
    public void setcategory(String category){
        this.category=category;
    }

    public Date getCreateTime(){
        return CreateTime;
    }
    public void setCreateTime(Date CreateTime){
        this.CreateTime=CreateTime;
    }
}
