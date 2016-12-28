package dbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class ResultSetHandlerTest_BeanList {

	public static void main(String[] args) {
		findAll();
		//findByPotNo(2210);
	}

	private static void findByPotNo(int potno) {
		// ��������
				Connection conn = ConnTools.makeConnection();
				// ����SQLִ�й���
				QueryRunner qRunner = new QueryRunner();
				ResultSetHandler<List<AeTable>> rsHandler=new BeanListHandler<AeTable>(AeTable.class);
				String sql = "select * from aetable where PotNo=? order by DDate Desc";
				try {
					@SuppressWarnings("unchecked")
					List<AeTable> result=qRunner.query(conn,sql, rsHandler,potno);		
					
					for(int i=0;i<result.size();i++){
						System.out.println(result.get(i).toString());
					}
					System.out.println("��¼������" + result.size());
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
		ResultSetHandler<List<AeTable>> rsHandler=new BeanListHandler<AeTable>(AeTable.class);
		String sql = "select * from aetable";
		try {
			@SuppressWarnings("unchecked")
			List<AeTable> result=qRunner.query(conn,sql, rsHandler);		
			
			for(int i=0;i<result.size();i++){
				System.out.println(result.get(i).toString());
			}
			System.out.println("��¼������" + result.size());
			DbUtils.closeQuietly(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
