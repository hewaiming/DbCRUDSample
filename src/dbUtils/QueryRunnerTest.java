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
		// ��������
		Connection conn = ConnTools_otherSvr.makeConnection();
		// ����SQLִ�й���
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
		// ��������
				Connection conn = ConnTools.makeConnection();
				// ����SQLִ�й���
				QueryRunner qRunner = new QueryRunner();

				String sql = "select * from aetable where PotNo=? Order by DDate Desc";
				try {
					List<AeTable> list = (List<AeTable>) qRunner.query(conn, sql, new BeanListHandler(AeTable.class),potno);
					for (AeTable aeTable : list) {
						System.out.println(aeTable);
					}
					System.out.println("��¼������"+list.size());
					 //�ر����ݿ����� 
					DbUtils.closeQuietly(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}

		
	}

	private static void findAll() {
		// ��������
		Connection conn = ConnTools.makeConnection();
		// ����SQLִ�й���
		QueryRunner qRunner = new QueryRunner();

		String sql = "select * from aetable";
		try {
			List<AeTable> list = (List<AeTable>) qRunner.query(conn, sql, new BeanListHandler(AeTable.class));
			for (AeTable aeTable : list) {
				System.out.println(aeTable);
			}
			System.out.println("��¼������"+list.size());
			DbUtils.closeQuietly(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
