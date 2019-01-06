package njnu15.tool;

import njnu15.bean.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static List<Album> findAllAlbum(User user){
        List<Album> list=new ArrayList<>();
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "SELECT * FROM album WHERE UserId='"+ user.getUserId() +"'";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Album album=new Album();
                album.setAlbumId(rs.getInt("AlbumId"));
                album.setAlbumName(rs.getString("AlbumName"));
                album.setUserId(rs.getString("UserId"));
                album.setCategory(rs.getString("Category"));
                album.setCreateTime(rs.getDate("CreateTime"));
                list.add(album);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Photo> findAllPhoto(int albumId){
        List<Photo> list=new ArrayList<>();
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "SELECT * FROM photo WHERE AlbumId='"+ albumId +"'";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Photo photo = new Photo();
                photo.setPhotoId(rs.getInt("PhotoId"));
                photo.setPhotoName(rs.getString("PhotoName"));
                photo.setPhotoURL(rs.getString("PhotoURL"));
                photo.setAlbumId(rs.getInt("AlbumId"));
                photo.setUploadTime(rs.getDate("UploadTime"));
                list.add(photo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String findFistPhoto(int albumId){
        String placeholder="D:/";
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "SELECT * FROM photo WHERE AlbumId='"+ albumId +"'";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()){
                return rs.getString("PhotoURL");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return placeholder;
    }
}
