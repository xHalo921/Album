package njnu15.tool;

import njnu15.bean.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private static void exesql(String sql){
        try {
            Connection conn= JDBCHelper.getConn();
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public static List<String> findAllFriends(String User){
        List<String> list=new ArrayList<>();
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "SELECT * FROM friends WHERE User='"+ User +"'";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                list.add(rs.getString("FriendId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String findFirstPhoto(int albumId){
        String placeholder="placeholder.png";
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "SELECT * FROM photo WHERE AlbumId='"+ albumId +"'";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()){
                return rs.getString("PhotoName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return placeholder;
    }

    public static List<Comment> findAllComment(int photoId){
        List<Comment> list=new ArrayList<>();
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "SELECT * FROM comment WHERE PhotoId='"+ photoId +"'";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Comment comment=new Comment();
                comment.setCommentId(rs.getInt("CommentId"));
                comment.setPhotoId(rs.getInt("PhotoId"));
                comment.setUser(rs.getString("User"));
                comment.setComments(rs.getString("Comments"));
                list.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void addAlbum(Album album){
        Timestamp t = new Timestamp(album.getCreateTime().getTime());
        String sql="insert Into album Values('"+album.getAlbumId()+"','"+album.getAlbumName()+"','"+album.getUserId()+"','"+t+"')";
        exesql(sql);
    }

    public static void addUser(User user){
        String sql = "Insert into user values('" + user.getUserId()+ "','" + user.getPassword() + "','"+ user.getGender() + "')";
        exesql(sql);
    }

    public static void addPhoto(Photo photo){
        Timestamp t = new Timestamp(photo.getUploadTime().getTime());
        String sql="insert Into photo(PhotoName,AlbumId,photoURL,UploadTime) Values('"+photo.getPhotoName()+"','"+photo.getAlbumId()+"','"+photo.getPhotoURL()+"','"+t+"')";
        exesql(sql);
    }

    public static void addComment(Comment comment){
        String sql="insert Into comment Values('insert Into albumValues('"+comment.getCommentId()+"','"+comment.getPhotoId()+"','"+comment.getUser()+"','"+comment.getComments()+"')";
        exesql(sql);
    }

    public static void delAlbum(int albumId){
        String sql="DELETE discuss,photo,album FROM album JOIN photo on photo.AlbumId=album.AlbumId JOIN discuss on photo.PhotoId=discuss.PhotoId WHERE AlbumId="+ albumId;
        exesql(sql);
    }

    public static void delPhoto(int photoId){
        String sql="DELETE discuss,photo FROM photo JOIN discuss on photo.PhotoId=discuss.PhotoId WHERE photo.PhotoId="+ photoId;
        exesql(sql);
    }

    public static void delComment(int commentId){
        String sql="DELETE FROM discuss WHERE CommentId='"+ commentId +"'";
        exesql(sql);
    }
}
