package courseOptServlet;

import com.google.gson.Gson;
import dao.courseDao.CourseDao;
import data.course.Course;
import data.responseMsg.ResponseMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteCourseServlet", urlPatterns = "/deleteCourse")
public class DeleteCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");

        Course course = new Course();
        course.setCourseId(courseId);

        //利用CourseDao进行数据库操作
        CourseDao dao = CourseDao.getInstance();
        ResponseMsg responseMsg = new ResponseMsg();

        if(dao.delete(course) == 1){
            responseMsg.setFig(1);
            responseMsg.setMsg("删除成功");
        }else {
            responseMsg.setFig(0);
            responseMsg.setMsg("删除失败");
        }

        Gson gson = new Gson();
        String data = gson.toJson(responseMsg);
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append(data);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
