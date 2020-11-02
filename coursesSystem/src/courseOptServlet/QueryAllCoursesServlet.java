package courseOptServlet;

import com.google.gson.Gson;
import dao.courseDao.CourseDao;
import data.course.Course;
import data.user.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QueryAllServlet", urlPatterns = "/queryAllCourses")
public class QueryAllCoursesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            CourseDao dao = new CourseDao();
            List<Course> courses = dao.queryAll();

            Gson gson = new Gson();
            String jsonString = gson.toJson(courses);
            System.out.println(jsonString);

            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.append(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
