package njnu15.tool;

import java.sql.*;

public class JDBCHelper {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL ="jdbc:mysql://localhost:3306/album?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static final String USER = "user";
    private static final String PASS = "123456";
    public static Connection getConn() throws Exception{
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }
}
