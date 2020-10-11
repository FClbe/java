import java.sql.*;

public class DbTest {

    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost:3306/db_zzt?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
    //用户名,更换成你自己的用户名，此处为root用户
    private static final String USER_NAME = "root";
    //密码，更换成你自己设定的密码，此处为:admin
    private static final String PASSWORD = "root";
    public static void main(String[] args){
        /**
         * 1.加载驱动
         *
         * 2.获取链接数据库的会话对象
         *
         * 3.通过数据库的会话对象获取执行对象
         *
         * 4.构造要执行的sql语句
         *
         * 5.使用数据库执行对象执行sql语句，并处理执行sql的状态结果
         *
         * 6.释放资源
         * */
        Connection connection = null;
        try {
            //加载mysql的驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //mysql查询语句
            //String sql = "SELECT name FROM demo";
            //PreparedStatement prst = connection.prepareStatement(sql);
            //结果集
            //ResultSet rs = prst.executeQuery();
            //while (rs.next()) {
                //System.out.println("用户名:" + rs.getString("name"));
            //}
            //rs.close();
            //prst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
