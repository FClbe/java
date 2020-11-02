package dao.teacherDao;

import com.google.gson.Gson;
import dao.IDao;
import data.user.Teacher;
import utils.DBUtil;

import java.util.List;

public class TeacherDao implements IDao<Teacher> {
    @Override
    public int insert(Teacher teacher) {
        if (teacher == null)
            return 0;
        Gson gson = new Gson();
            String jsonCourses = gson.toJson(teacher.getCourseNames());
        Object[] objects = {teacher.getAccountId(),teacher.getName(),jsonCourses};
        String sql = "insert into teacher values(?,?,?)";
        DBUtil dbUtil = new DBUtil();
        dbUtil.doUpdate(sql, objects);
        return 1;
    }

    @Override
    public int delete(Teacher teacher) {
        return 0;
    }

    @Override
    public int update(Teacher teacher) {
        return 0;
    }

    @Override
    public List<Teacher> query(Teacher teacher) {
        return null;
    }

    @Override
    public List<Teacher> queryAll() {
        return null;
    }
}
