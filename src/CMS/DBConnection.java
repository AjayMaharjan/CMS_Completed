
package CMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBConnection {
    static Connection connection;
    
    final static String subProtocol="mysql";
    final static String host="//localhost";
    final static String port="3306";
    final static String database="/cms";
    final static String username="cms";
    final static String password="password";
    //final static String url="cms:mysql://localhost:3306/cms";
    
    public static Connection getConnection() throws SQLException{
            if(connection==null || connection.isClosed()){
                connection=DriverManager.getConnection("jdbc:" + subProtocol + ":" + host + ":" +port+database,username,password);
//                connection=DriverManager.getConnection(url,username,password);
            }
            return connection;
    }
    public static void closeConnection() throws SQLException{
        if(connection!=null){
            connection.close();
        }
    }

}
