package selectCourseOptServlet;

import com.google.gson.Gson;
import dao.courseDao.CourseDao;
import dao.studentDao.StudentDao;
import data.course.Course;
import data.user.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QuerySelCourServlet",urlPatterns = "/querySelCourses")
public class QuerySelCourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountId = request.getParameter("accountId");
        try{
            Student temp = new Student();
            temp.setAccountId(accountId);
            StudentDao dao = new StudentDao();
            Student student = dao.query(temp).get(0);


            Gson gson = new Gson();
            String jsonString = gson.toJson(student.getSelectedCourses());
            System.out.println(jsonString);

            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.append(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
