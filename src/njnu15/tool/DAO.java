package njnu15.tool;

import njnu15.bean.Album;
import njnu15.bean.User;

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
            String sql = "SELECT * FROM album WHERE user='"+ user.getUserId() +"'";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Album album=new Album();
                album.setAlbumId(rs.getInt("AlbumId"));
                album.setAlbumName(rs.getString("AlbumName"));
                album.setUserId(rs.getInt("UserId"));
                album.setCategory(rs.getString("Category"));
                album.setCreateTime(rs.getDate("CreateTime"));
                list.add(album);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}