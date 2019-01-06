package njnu15.bean;

import java.util.Date;

public class Photo {
    private int PhotoId;
    private String PhotoName;
    private int AlbumId;
    private String PhotoURL;
    private Date UploadTime;

    public int getPhotoId(){
        return PhotoId;
    }
    public void setPhotoId(int PhotoId){
        this.PhotoId=PhotoId;
    }

    public String getPhotoName(){
        return PhotoName;
    }
    public void setPhotoName(String PhotoName){
        this.PhotoName=PhotoName;
    }

    public int getAlbumId(){
        return AlbumId;
    }
    public void setAlbumId(int AlbumId){
        this.AlbumId=AlbumId;
    }

    public String getPhotoURL(){
        return PhotoURL;
    }
    public void setPhotoURL(String PhotoURL){
        this.PhotoURL=PhotoURL;
    }

    public Date getUploadTime(){
        return UploadTime;
    }
    public void setUploadTime(Date UploadTime){
        this.UploadTime=UploadTime;
    }
}
