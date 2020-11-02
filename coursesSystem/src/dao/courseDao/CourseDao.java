package dao.courseDao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dao.IDao;
import data.course.Course;
import data.user.Student;
import data.user.Teacher;
import sun.security.pkcs11.Secmod;
import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao implements IDao<Course> {

    private static CourseDao dao = null;

    public static CourseDao getInstance() {
        if (dao == null){
            dao = new CourseDao();
        }
        return dao;
    }
    @Override
    public int insert(Course course) {

        if (course == null)
            return 0;
        if (course.getStudentList() == null){
            course.setStudentList(new ArrayList<>());
        }
        Gson gson = new Gson();
        String jsonTeacher = gson.toJson(course.getTeacher());
        System.out.println("--------CourseDao insert---" + jsonTeacher+ "-----------");
        String jsonStudents = gson.toJson(course.getStudentList());
        Object[] objects = {course.getCourseId(),course.getName(),course.getLearningTime()
        ,course.getLearningScore(),course.getPlace(),course.getSelectedNum(),course.getMaxSelectedNum()
        ,jsonTeacher,jsonStudents};
        String sql = "insert into course values(?,?,?,?,?,?,?,?,?)";
        DBUtil dbUtil = new DBUtil();
        int result = dbUtil.doUpdate(sql, objects);
        dbUtil.close();
        return result;
    }

    @Override
    public int delete(Course course) {
        if (course == null)
            return 0;
        String sql = "delete from course where courseId = ?";
        Object[] params = {course.getCourseId()};
        DBUtil dbUtil = new DBUtil();
        int result = dbUtil.doUpdate(sql, params);
        dbUtil.close();
        return result;
    }

    @Override
    public int update(Course course) {
        if (course == null)
            return 0;
        Gson gson = new Gson();
        String jsonTeacher = gson.toJson(course.getTeacher());
        System.out.println("--------CourseDao insert---" + jsonTeacher+ "-----------");
        String jsonStudents = gson.toJson(course.getStudentList());
        Object[] objects = {course.getName(),course.getLearningTime()
                ,course.getLearningScore(),course.getPlace(),course.getSelectedNum(),course.getMaxSelectedNum()
                ,jsonTeacher,jsonStudents,course.getCourseId()};
        String sql = "update course set name = ?," +
                "learningTime = ?," +
                "learningScore = ?," +
                "place = ?," +
                "selectedNum = ?," +
                "maxSelected = ?," +
                "teacher = ?," +
                "studentList = ?" +
                "where courseId = ?";
        DBUtil dbUtil = new DBUtil();
        int result = dbUtil.doUpdate(sql, objects);
        dbUtil.close();
        return result;
    }

    @Override
    public List<Course> query(Course course) {
        List<Course> list = new ArrayList<>();
        Gson gson = new Gson();
        DBUtil dbUtil = new DBUtil();

        Object[] params = {course.getCourseId()};
        String sql = "select * from course where courseId = ?";
        ResultSet rs = dbUtil.doQuery(sql, params);

        if (rs == null){
            return null;
        }
        try {
            while (rs.next()){
                Course course1 = new Course();
                course1.setCourseId(rs.getString(1));
                course1.setName(rs.getString(2));
                course1.setLearningTime(rs.getInt(3));
                course1.setLearningScore(rs.getInt(4));
                course1.setPlace(rs.getString(5));
                course1.setSelectedNum(rs.getInt(6));
                course1.setMaxSelectedNum(rs.getInt(7));
                course1.setTeacher(gson.fromJson(rs.getString(8),Teacher.class));
                course1.setStudentList(gson.fromJson(rs.getString(9),new TypeToken<List<String>>(){}.getType()));
                list.add(course1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dbUtil.close();
        return list;
    }

    @Override
    public List<Course> queryAll() {
        List<Course> list = new ArrayList<>();
        Gson gson = new Gson();
        DBUtil dbUtil = new DBUtil();

        String sql = "select * from course";
        ResultSet rs = dbUtil.doQuery(sql, null);

        if (rs == null){
            return null;
        }
        try {
            while (rs.next()){
                Course course = new Course();
                course.setCourseId(rs.getString(1));
                course.setName(rs.getString(2));
                course.setLearningTime(rs.getInt(3));
                course.setLearningScore(rs.getInt(4));
                course.setPlace(rs.getString(5));
                course.setSelectedNum(rs.getInt(6));
                course.setMaxSelectedNum(rs.getInt(7));
                course.setTeacher(gson.fromJson(rs.getString(8),Teacher.class));
                course.setStudentList(gson.fromJson(rs.getString(9),new TypeToken<List<String>>(){}.getType()));
                list.add(course);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dbUtil.close();
        return list;
    }
}
