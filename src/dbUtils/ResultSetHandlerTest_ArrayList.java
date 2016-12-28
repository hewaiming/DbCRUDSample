package dbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.sun.javafx.collections.MappingChange.Map;

public class ResultSetHandlerTest_ArrayList {

	public static void main(String[] args) {
		findAll();
		//findByPotNo(2210);
	}

	private static void findByPotNo(int potno) {
		// ��������
				Connection conn = ConnTools.makeConnection();
				// ����SQLִ�й���
				QueryRunner qRunner = new QueryRunner();
				ResultSetHandler<List<Object[]>> rsHandler=new ArrayListHandler();
				String sql = "select * from aetable where PotNo=? order by DDate Desc";
				try {
					@SuppressWarnings("unchecked")
					List<Object[]> result=qRunner.query(conn,sql, rsHandler,potno);		
					
					for(int i=0;i<result.size();i++){
						Object[] arr=result.get(i);
						for(int j=0;j<arr.length;j++){
							System.out.print(arr[j].toString()+"\t");
						}
						System.out.println("");
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
		ResultSetHandler<List<Object[]>> rsHandler=new ArrayListHandler();
		String sql = "select * from aetable";
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> result=qRunner.query(conn,sql, rsHandler);		

			for(int i=0;i<result.size();i++){
				Object[] arr=result.get(i);
				for(int j=0;j<arr.length;j++){
					System.out.print(arr[j].toString()+"\t");
				}
				System.out.println("");
			}
			System.out.println("��¼������" + result.size());			
		
			DbUtils.closeQuietly(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
