package njnu15.tool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlbumCategory {
    private static List<String> list= new ArrayList<String>();
    static {
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "SELECT category FROM category";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                list.add(rs.getString("category"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<String> getAlbumCategory(){
        return list;
    }

    public static void addCategory(String s){
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "INSERT INTO category (category) VALUE('"+s+"')";
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delCategory(int i){
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "DELETE FROM category WHERE id="+i;
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
