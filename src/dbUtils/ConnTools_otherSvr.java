package dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnTools_otherSvr { 
	//sqlserver2005
        private static String dirverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
        private static String url = "jdbc:sqlserver://172.16.0.1:1433;DatabaseName=Dj_test"; 
        private static String user = "sa"; 
        private static String password = "asdfghjkl"; 

        public static Connection makeConnection() { 
                Connection conn = null; 
                try { 
                        Class.forName(dirverClassName); 
                } catch (ClassNotFoundException e) { 
                        e.printStackTrace(); 
                } 
                try { 
                        conn = DriverManager.getConnection(url, user, password); 
                } catch (SQLException e) { 
                        e.printStackTrace(); 
                } 
                return conn; 
        } 
}