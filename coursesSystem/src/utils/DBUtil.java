package utils;

import com.mysql.cj.xdevapi.JsonArray;

import java.sql.*;

public class DBUtil {
    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost:3306/db_coursesystem?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
    //用户名,更换成你自己的用户名，此处为root用户
    private static final String USER_NAME = "root";
    //密码，更换成你自己设定的密码，此处为:admin
    private static final String PASSWORD = "root";

    private Connection conn;
    private PreparedStatement preparedStatement;
    private static DBUtil dbUtil = null;
    private volatile int count = 0;


    static {
        try {
            Class.forName(DRIVER_NAME);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection getConn() {
        try{
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }

    public ResultSet doQuery(String sql, Object[] params){
        getConn();
        try {
            preparedStatement = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (params != null && params.length != 0){
            for (int i = 0; i < params.length; i++){
                try {
                    preparedStatement.setObject(i + 1, params[i]);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        ResultSet set = null;
        try {
            set = preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return set;
    }

    public int doUpdate(String sql, Object[] params){
        int result = 0;
        System.out.println("--------DBUtil doUpdate--------------");
        getConn();
        try {
            preparedStatement = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (params != null && params.length != 0){
            for (int i = 0; i < params.length; i++){
                try {
                    preparedStatement.setObject(i + 1, params[i]);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        try {
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;

    }

    public void close(){
        if (preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }



}
