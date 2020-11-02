package dao.studentDao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dao.IDao;
import data.account.Account;
import data.selectCourse.SelectedCourse;
import data.user.Student;
import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IDao<Student> {
    @Override
    public int insert(Student student) {
        if (student == null)
            return 0;
        Gson gson = new Gson();
        if (student.getSelectedCourses() == null){
            student.setSelectedCourses(new ArrayList<>());
        }
        String jsonSelectedCourses = gson.toJson(student.getSelectedCourses());
        Object[] objects = {student.getAccountId(),student.getName(),jsonSelectedCourses};
        String sql = "insert into student values(?,?,?)";
        DBUtil dbUtil = new DBUtil();
        int result = dbUtil.doUpdate(sql, objects);
        dbUtil.close();
        return result;
    }

    @Override
    public int delete(Student student) {
        return 0;
    }

    @Override
    public int update(Student student) {
        if (student == null)
            return 0;
        Gson gson = new Gson();
        String jsonSelectedCourses = gson.toJson(student.getSelectedCourses());
        Object[] objects = {student.getName(),jsonSelectedCourses,student.getAccountId()};
        String sql = "update student set name = ?," +
                "selectCourse = ?" +
                "where accountId = ?";
        DBUtil dbUtil = new DBUtil();
        int result = dbUtil.doUpdate(sql, objects);
        dbUtil.close();
        return result;
    }

    @Override
    public List<Student> query(Student student) {
        List<Student> list = new ArrayList<>();
        Gson gson = new Gson();
        DBUtil dbUtil = new DBUtil();

        Object[] params = {student.getAccountId()};
        String sql = "select * from student where accountId = ?";

        ResultSet rs = dbUtil.doQuery(sql, params);

        if (rs == null){
            return null;
        }
        try {
            while (rs.next()){
                Student student1 = new Student();
                student1.setAccountId(rs.getString(1));
                student1.setName(rs.getString(2));
                student1.setSelectedCourses(gson.fromJson(rs.getString(3), new TypeToken<List<SelectedCourse>>() {}.getType()));
                list.add(student1);
                System.out.println(student1.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dbUtil.close();
        return list;
    }

    @Override
    public List<Student> queryAll() {
        return null;
    }
}
