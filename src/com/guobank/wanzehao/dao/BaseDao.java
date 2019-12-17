package com.guobank.wanzehao.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDao {

	protected static Connection connection;

	static {
//		Properties properties = new Properties();
//		InputStream inputStream = BaseDao.class.getClassLoader()
//				.getResourceAsStream("database.properties");
//		try {
//			properties.load(inputStream);
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		String driver = properties.getProperty("driver");
//		String url = properties.getProperty("url");
//		String username = properties.getProperty("user");
//		String password = properties.getProperty("password");

		try {
			//Class.forName(driver);
			//connection = DriverManager.getConnection(url, username, password);

			//调用数据源连接池，获取数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://192.168.43.43:3306/guobank","myuser","mypassword");
			System.out.println(connection);
		}
		catch (Exception e)   {
			e.printStackTrace();
		}

	}

	public void closeConnection(Connection connection, Statement statement,
			ResultSet resultSet) throws Exception {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	/**
	 * ִ������ɾ����
	 * 
	 * @param sql
	 * @param params ����ֵ����
	 * @throws Exception
	 */
	public void executeUpdate(String sql, Object[] params) throws Exception {
		PreparedStatement ps = connection.prepareStatement(sql);

		// ���ò���
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}
		// ִ��
		ps.executeUpdate();

		// �ر�
		//this.closeConnection(connection, ps, null);
	}

	public ResultSet executeQuery(String sql, Object[] params) throws Exception {

		PreparedStatement ps = connection.prepareStatement(sql);

		// ���ò���
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}

		ResultSet rs = ps.executeQuery();
		return rs;
	}

}
