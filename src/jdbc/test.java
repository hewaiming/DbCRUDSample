package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	private static ResultSet rs;
	

	public static void main(String[] args) {
		// 加载JDBC驱动
		String DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// 连接服务器和数据库
		String DBURL = "jdbc:sqlserver://172.16.0.2:1433;DatabaseName=gx_data";
		String userName = "sa"; // 默认用户名
		String userPwd = "asdfghjkl"; // 密码
		Connection dbConn=null;
		Statement stmt=null;
		try {
			Class.forName(DriverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
		}	
		try {
			dbConn=DriverManager.getConnection(DBURL, userName, userPwd);
			System.out.println("数据库连接ok！");
			stmt = dbConn.createStatement();
			 //执行结果集
			 rs=stmt.executeQuery("select * from aetable ");
			 while (rs.next()) {
		            System.out.println(rs.getString("potno") + " : " + rs.getString("ddate"));
		         }
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");   
			e.printStackTrace();
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(dbConn!=null )
				try {
					dbConn.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
		}
		
	}

}
