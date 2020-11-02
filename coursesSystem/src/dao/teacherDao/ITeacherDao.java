package dao.teacherDao;

import data.user.Teacher;

import java.util.List;

public interface ITeacherDao {
    int insert();
    int delete();
    List<Teacher> query();
}
