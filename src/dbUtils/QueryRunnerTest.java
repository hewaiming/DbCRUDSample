package dbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class QueryRunnerTest {

	public static void main(String[] args) {
		//findbyPotNo(2210);
		//findAll();
		addUser();

	}

	private static void addUser() {
		// 创建连接
		Connection conn = ConnTools_otherSvr.makeConnection();
		// 创建SQL执行工具
		QueryRunner qRunner = new QueryRunner();
		String ins_sql = "insert into OperaterTable (Name) values (?)"; 
		try {
			qRunner.update(conn, ins_sql,"gy");	
			//qRunner.update(conn, ins_sql, yourname);
			System.out.println("insert ok!");
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
	}

	private static void findbyPotNo(int potno) {
		// 创建连接
				Connection conn = ConnTools.makeConnection();
				// 创建SQL执行工具
				QueryRunner qRunner = new QueryRunner();

				String sql = "select * from aetable where PotNo=? Order by DDate Desc";
				try {
					List<AeTable> list = (List<AeTable>) qRunner.query(conn, sql, new BeanListHandler(AeTable.class),potno);
					for (AeTable aeTable : list) {
						System.out.println(aeTable);
					}
					System.out.println("记录总数："+list.size());
					 //关闭数据库连接 
					DbUtils.closeQuietly(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}

		
	}

	private static void findAll() {
		// 创建连接
		Connection conn = ConnTools.makeConnection();
		// 创建SQL执行工具
		QueryRunner qRunner = new QueryRunner();

		String sql = "select * from aetable";
		try {
			List<AeTable> list = (List<AeTable>) qRunner.query(conn, sql, new BeanListHandler(AeTable.class));
			for (AeTable aeTable : list) {
				System.out.println(aeTable);
			}
			System.out.println("记录总数："+list.size());
			DbUtils.closeQuietly(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
