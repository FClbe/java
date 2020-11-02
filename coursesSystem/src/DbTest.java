import com.google.gson.Gson;
import dao.studentDao.StudentDao;
import data.course.Course;
import data.user.Student;
import data.user.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        Teacher teacher = new Teacher();
        teacher.setName("teacher");
        List<Course> courses = new ArrayList<>();
        Course course = new Course();
        course.setCourseId("1");
        course.setName("数学");
        course.setMaxSelectedNum(7);
        course.setPlace("东九楼");
        course.setTeacher(teacher);
        courses.add(course);

        List<String> list = new ArrayList<>();
        list.add("1");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Gson gson = new Gson();
        String jsonString = gson.toJson(courses);
        System.out.println(jsonString);

        List<Course> courses1 = gson.fromJson((String)null,List.class);
        System.out.println(courses1.toString());

        int i = 1;
        if (i == 1){
            return;
        }

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
