package courseOptServlet;

import com.google.gson.Gson;
import dao.courseDao.CourseDao;
import data.course.Course;
import data.responseMsg.ResponseMsg;
import data.user.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddCourseServlet",urlPatterns = "/addCourse")
public class AddCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        System.out.println("-------------请求添加课程-----------------");
        //courseId, name, learningTime, learningScore, place, maxSelectedNum, teacher
        String courseId = request.getParameter("courseId");

        String name = request.getParameter("name");
        int learningTime = Integer.parseInt(request.getParameter("learningTime"));
        int learningScore = Integer.parseInt(request.getParameter("learningScore"));
        String place = request.getParameter("place");
        int maxSelectedNum = Integer.parseInt(request.getParameter("maxSelectedNum"));
        String teacherName = request.getParameter("teacherName");

        System.out.println("-------------请求添加课程---courseId--------------" + teacherName);

        Teacher teacher = new Teacher();
        teacher.setName(teacherName);

        //构造存储对象
        Course course = new Course();
        course.setCourseId(courseId);
        course.setName(name);
        course.setLearningTime(learningTime);
        course.setLearningScore(learningScore);
        course.setPlace(place);
        course.setMaxSelectedNum(maxSelectedNum);
        course.setTeacher(teacher);

        //利用CourseDao存进数据库
        CourseDao dao = CourseDao.getInstance();
        ResponseMsg responseMsg = new ResponseMsg();

        if(dao.insert(course) == 1){
            responseMsg.setFig(1);
            responseMsg.setMsg("添加成功");
        }else {
            responseMsg.setFig(0);
            responseMsg.setMsg("添加失败");
        }

        Gson gson = new Gson();
        String data = gson.toJson(responseMsg);
        PrintWriter writer = response.getWriter();
        writer.append(data);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
