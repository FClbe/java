package selectCourseOptServlet;

import com.google.gson.Gson;
import data.responseMsg.ResponseMsg;
import utils.SelectCourseOptUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DelSelCourServlet",urlPatterns = "/delSelCourse")
public class DelSelCourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountId = request.getParameter("accountId");
        String courseId = request.getParameter("courseId");
        System.out.println("--------选课发生异常--------------------" + accountId + courseId);
        ResponseMsg responseMsg = new ResponseMsg();
        int result = SelectCourseOptUtil.delSelCourse(accountId,courseId);
        if(result == 1){
            responseMsg.setFig(1);
            responseMsg.setMsg("退选成功");
        }else {
            responseMsg.setFig(0);
            responseMsg.setMsg("退选失败");
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
