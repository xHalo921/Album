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

    public static String findFirstPhoto(int albumId){
        String placeholder="placeholder.png";
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
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "insert Into albumValues('"+album.getAlbumId()+"','"+album.getAlbumName()+"','"+album.getUserId()+"','"+album.getCreateTime()+"')";
            Statement stmt=conn.createStatement();
            stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addPhoto(Photo photo){
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "insert Into albumValues('"+photo.getPhotoId()+"','"+photo.getPhotoName()+"','"+photo.getAlbumId()+"','"+photo.getPhotoURL()+"','"+photo.getUploadTime()+"')";
            Statement stmt=conn.createStatement();
            stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addComment(Comment comment){
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "insert Into albumValues('"+comment.getCommentId()+"','"+comment.getPhotoId()+"','"+comment.getUser()+"','"+comment.getComments()+"')";
            Statement stmt=conn.createStatement();
            stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
