package njnu15.tool;

import njnu15.bean.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private static void updateSql(String sql){
        try {
            Connection conn= JDBCHelper.getConn();
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ResultSet exeSql(String sql){
        ResultSet rs=null;
        try {
            Connection conn= JDBCHelper.getConn();
            Statement stmt=conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static List<Album> findAllAlbum(User user){
        List<Album> list=new ArrayList<>();
        try {
            String sql = "SELECT * FROM album WHERE UserId='"+ user.getUserId() +"'";
            ResultSet rs = exeSql(sql);
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
            String sql = "SELECT * FROM photo WHERE AlbumId='"+ albumId +"'";
            ResultSet rs = exeSql(sql);
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
            String sql = "SELECT * FROM friends WHERE User='"+ User +"'";
            ResultSet rs = exeSql(sql);
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
            String sql = "SELECT * FROM photo WHERE AlbumId='"+ albumId +"'";
            ResultSet rs = exeSql(sql);
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
            String sql = "SELECT * FROM discuss WHERE PhotoId='"+ photoId +"'";
            ResultSet rs = exeSql(sql);
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

    public static void changeAlbum(int albumId,String aname,String cate){
        if(aname=="" && cate=="") {
            return;
        }
        try{
            Connection conn= JDBCHelper.getConn();
            Statement stmt=conn.createStatement();
            if(aname!=""&&cate!=""){
                String sql="update album set AlbumName = '"+aname+"',Category='"+cate+"' where AlbumId = '"+albumId+"'";
                stmt.executeUpdate(sql);
            } else if(aname!=""&&cate==""){
                String sql="update album set AlbumName = '"+aname+"' where AlbumId = '"+albumId+"'";
                stmt.executeUpdate(sql);
            } else if(aname==""&&cate!=""){
                String sql="update album set Category = '"+cate+"' where AlbumId = '"+albumId+"'";
                stmt.executeUpdate(sql);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static int findAlbum(int photoId){
        int albumId = 0;
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "SELECT AlbumId FROM photo WHERE PhotoId='"+ photoId +"'";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                albumId=rs.getInt("AlbumId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albumId;
    }

    public static void addAlbum(Album album){
        Timestamp t = new Timestamp(album.getCreateTime().getTime());
        String sql="insert Into album Values('"+album.getAlbumId()+"','"+album.getAlbumName()+"','"+album.getUserId()+"','"+t+"')";
        updateSql(sql);
    }

    public static void addUser(User user){
        String sql = "Insert into user values('" + user.getUserId()+ "','" + user.getPassword() + "','"+ user.getGender() + "')";
        updateSql(sql);
    }

    public static void addPhoto(Photo photo){
        Timestamp t = new Timestamp(photo.getUploadTime().getTime());
        String sql="insert Into photo(PhotoName,AlbumId,photoURL,UploadTime) Values('"+photo.getPhotoName()+"','"+photo.getAlbumId()+"','"+photo.getPhotoURL()+"','"+t+"')";
        updateSql(sql);
    }

    public static void addComment(Comment comment){
        String sql="insert Into discuss (PhotoId,User,Comments) Values('"+comment.getPhotoId()+"','"+comment.getUser()+"','"+comment.getComments()+"')";
        updateSql(sql);
    }

    public static int addFriend(String friendId,String userId){
        String sql="SELECT* FROM user WHERE User='"+friendId+"'";
        String sql2="SELECT* FROM friends WHERE User='"+userId+"' AND FriendId='"+friendId+"'";
        try {
            ResultSet rs = exeSql(sql);
            if (!rs.next()){
                return -1;
            }
            rs = exeSql(sql2);
            if (rs.next()){
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql="insert Into friends Values('"+userId+"','"+friendId+"')";
        updateSql(sql);
        return 1;
    }

    public static void delAlbum(int albumId){
        String sql="DELETE FROM album WHERE AlbumId='"+ albumId+"'";
        updateSql(sql);
    }

    public static void delPhoto(int photoId){
        String sql="DELETE FROM photo  WHERE PhotoId='"+ photoId+"'";
        updateSql(sql);
    }

    public static void delComment(int commentId){
        String sql="DELETE FROM discuss WHERE CommentId='"+ commentId +"'";
        updateSql(sql);
    }

    public static void delFriend(String friendId,String userId){
        String sql="DELETE FROM friends WHERE User='"+userId+"' AND FriendId='"+friendId+"'";
        System.out.println(sql);
        updateSql(sql);
    }
}
