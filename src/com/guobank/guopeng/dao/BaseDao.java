package com.guobank.guopeng.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @description:JDBC:����
 * @author: john
 * @date: 2019-8-15
 * @version 1.0
 * @since JDK1.7
 */
public class BaseDao {
	protected static Connection connection;
	static{
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/guobank?useUnicode=true&characterEnc", "root", "123456");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ������ݿ�����
	 * @return Connection
	 */
//	public Connection getConnection() throws Exception{
//		
//		return connection;
//	}
	
	/**
	 * 
	 * �ر���ݿ����ӣ��ͷ���Դ
	 * @param connection ��������
	 * @param statement ��������
	 * @param rs ���
	 * @throws Exception
	 */
	public void closeConnection(Connection connection,Statement statement,ResultSet rs) throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(statement!=null){
			statement.close();
		}
		if(connection!=null){
			connection.close();
		}
	}
	
	
	/**
	 * ִ������ɾ���Ĳ���
	 * @param sql ����ɾ�������
	 * @param params ��������
	 */
	public void executeUpdate(String sql,Object[] params)throws Exception{
		//�������ӣ�������������
		PreparedStatement ps=connection.prepareStatement(sql);
		
		//���ò���
		if (params !=null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1,params[i]);
			}
		}
		
		//ִ��
		ps.executeUpdate();
		//�ر�
		//hthis.closeConnection(connection,ps,null);
	}
	
	/**
	 * ��ѯ
	 * @param sql ��ѯSQL���
	 * @param params
	 * @return ���
	 * @throws Exception
	 */
	public ResultSet query(String sql,Object[] params)throws Exception{
		//�������ӣ�������������
		PreparedStatement ps=connection.prepareStatement(sql);
		//���ò���
		if (params !=null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1,params[i]);
			}
		}
		ResultSet rs=ps.executeQuery();
		return rs;
	}
}
