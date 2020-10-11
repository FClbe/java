package utils;

import com.mysql.cj.xdevapi.JsonArray;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost:3306/db_zzt?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
    //用户名,更换成你自己的用户名，此处为root用户
    private static final String USER_NAME = "root";
    //密码，更换成你自己设定的密码，此处为:admin
    private static final String PASSWORD = "root";

    private static Connection conn;

    static {
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
