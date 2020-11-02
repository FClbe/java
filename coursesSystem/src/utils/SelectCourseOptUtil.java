package utils;

import dao.studentDao.StudentDao;
import dao.courseDao.CourseDao;
import data.course.Course;
import data.selectCourse.SelectedCourse;
import data.user.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectCourseOptUtil {
    public static int selectCourse(String accountId, String courseId){
        Course course = new Course();
        course.setCourseId(courseId);
        CourseDao courseDao = new CourseDao();
        List<Course> courses = courseDao.query(course);
        if (courses.isEmpty() || courses == null){
            System.out.println("--选课失败-----找不到课------");
            return 0;
        }

        Course selectCourse = courses.get(0);
        SelectedCourse selectedCourse = new SelectedCourse();
        selectedCourse.setCourse(selectCourse);
        selectedCourse.setStatus(1);

        System.out.println("h");
        Student student = new Student();
        student.setAccountId(accountId);
        StudentDao studentDao = new StudentDao();
        System.out.println("hh");
        List<Student> students = studentDao.query(student);
        if (students.isEmpty() || students == null){
            System.out.println("--选课失败-----找不到学生------");
            return 0;
        }

        System.out.println("hh");
        Student selectStudent = students.get(0);
        List<SelectedCourse> list = selectStudent.getSelectedCourses();
        if (list == null){
            list = new ArrayList<>();
        }

        for (SelectedCourse c :
                list) {
            if (c.getCourse().getCourseId().equals(courseId)){
                return 2;
            }
        }

        selectCourse.setSelectedNum(selectCourse.getSelectedNum() + 1);
        selectedCourse.setStatus(1);
        list.add(selectedCourse);
        System.out.println("hh");
        selectStudent.setSelectedCourses(list);
        if (studentDao.update(selectStudent) == 0){
            System.out.println("--选课失败-----学生表更新失败------");
            return 0;
        }

        List<String> studentList = selectCourse.getStudentList();
        studentList.add(selectStudent.getAccountId());
        selectCourse.setStudentList(studentList);
        if (courseDao.update(selectCourse) == 0){
            System.out.println("--选课失败-----课表更新失败------");
            return 0;
        }

        return 1;
    }

    public static int delSelCourse(String accountId, String courseId){
        Course course = new Course();
        course.setCourseId(courseId);
        CourseDao courseDao = new CourseDao();
        List<Course> courses = courseDao.query(course);
        if (courses.isEmpty() || courses == null){
            System.out.println("--退选失败-----找不到课------");
            return 0;
        }

        Course selectCourse = courses.get(0);
        SelectedCourse selectedCourse = new SelectedCourse();
        selectedCourse.setCourse(selectCourse);
        selectedCourse.setStatus(1);

        System.out.println("h");
        Student student = new Student();
        student.setAccountId(accountId);
        StudentDao studentDao = new StudentDao();
        System.out.println("hh");
        List<Student> students = studentDao.query(student);
        if (students.isEmpty() || students == null){
            System.out.println("--退选失败-----找不到学生------");
            return 0;
        }

        System.out.println("hh");
        Student selectStudent = students.get(0);
        List<SelectedCourse> list = selectStudent.getSelectedCourses();
        if (list == null){
            list = new ArrayList<>();
        }

        Iterator<SelectedCourse> iterator1 = list.iterator();
        while (iterator1.hasNext()){
            if (iterator1.next().getCourse().getCourseId().equals(courseId)){
                iterator1.remove();
            }
        }

        selectCourse.setSelectedNum(selectCourse.getSelectedNum() - 1);
        selectStudent.setSelectedCourses(list);
        if (studentDao.update(selectStudent) == 0){
            System.out.println("--退选失败-----学生表更新失败------");
            return 0;
        }

        List<String> studentList = selectCourse.getStudentList();
        Iterator<String> iterator2 = studentList.iterator();
        while (iterator2.hasNext()){
            if (iterator2.next().equals(accountId)){
                iterator2.remove();
            }
        }
        selectCourse.setStudentList(studentList);
        if (courseDao.update(selectCourse) == 0){
            System.out.println("--退选失败-----课表更新失败------");
            return 0;
        }

        return 1;
    }

}
