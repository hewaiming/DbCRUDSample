package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	private static ResultSet rs;
	

	public static void main(String[] args) {
		// ����JDBC����
		String DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// ���ӷ����������ݿ�
		String DBURL = "jdbc:sqlserver://172.16.0.2:1433;DatabaseName=gx_data";
		String userName = "sa"; // Ĭ���û���
		String userPwd = "asdfghjkl"; // ����
		Connection dbConn=null;
		Statement stmt=null;
		try {
			Class.forName(DriverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�Ҳ������������� ����������ʧ�ܣ�");
		}	
		try {
			dbConn=DriverManager.getConnection(DBURL, userName, userPwd);
			System.out.println("���ݿ�����ok��");
			stmt = dbConn.createStatement();
			 //ִ�н����
			 rs=stmt.executeQuery("select * from aetable ");
			 while (rs.next()) {
		            System.out.println(rs.getString("potno") + " : " + rs.getString("ddate"));
		         }
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ�ܣ�");   
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
