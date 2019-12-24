package com.guobank.dao;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Properties;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: MyBank
 * @Package com.guobank.dao
 * @Descriptio /**
 * @Project: MyBank
 * @Package com.guobank.dao
 * @Description: TODO
 * @date Date : 2019年11月07日 8:59
 */
public class BaseDao {
    private static Connection conn;

    static {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.43.43:3306/guobank","myuser","mypassword");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean execute(String sql, Object[] params) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        if (params != null) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject((i + 1), params[i]);
            }
        }
        return ps.execute();
    }

    protected ResultSet query(String sql, Object[] params) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject((i + 1), params[i]);
            }
        }
        return ps.executeQuery();
    }



    public ResultSet executeQuery(String sql, Object[] params) throws SQLException {

        PreparedStatement ps = conn.prepareStatement(sql);

        // ���ò���
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }

        ResultSet rs = ps.executeQuery();
        return rs;
    }

    /**
     * ִ������ɾ����
     *
     * @param sql
     * @param params ����ֵ����
     * @throws Exception
     */
    public Boolean executeUpdate(String sql, Object[] params) throws Exception {
        PreparedStatement ps = conn.prepareStatement(sql);

        // ���ò���
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }
        // ִ��
        return   ps.execute();


        // �ر�
        //this.closeConnection(connection, ps, null);
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

}
