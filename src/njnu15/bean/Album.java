package njnu15.bean;

import java.util.Date;

public class Album {
    private int AlbumId;
    private String AlbumName;
    private String UserId;
    private String Category;
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

    public String getCategory(){
        return Category;
    }
    public void setCategory(String Category){
        this.Category=Category;
    }

    public Date getCreateTime(){
        return CreateTime;
    }
    public void setCreateTime(Date CreateTime){
        this.CreateTime=CreateTime;
    }
}
