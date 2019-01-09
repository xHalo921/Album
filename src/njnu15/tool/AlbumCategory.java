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
            String sql = "SELECT categoryName FROM category";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                list.add(rs.getString("categoryName"));
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
            String sql = "INSERT INTO category (categoryName) VALUE('"+s+"')";
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.add(s);
    }

    public static void delCategory(String cn){
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "DELETE FROM category WHERE categoryName='"+cn+"'";
            System.out.println(sql);
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.remove(cn);
    }
}
