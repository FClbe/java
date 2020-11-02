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

@WebServlet(name = "SelectCourseServlet", urlPatterns = "/selectCourse")
public class SelectCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountId = request.getParameter("accountId");
        String courseId = request.getParameter("courseId");
        System.out.println("--------选课发生异常--------------------" + accountId + courseId);
        ResponseMsg responseMsg = new ResponseMsg();
        int result = SelectCourseOptUtil.selectCourse(accountId,courseId);
        if(result == 1){
            responseMsg.setFig(1);
            responseMsg.setMsg("选课成功");
        }else if(result == 2) {
            responseMsg.setFig(0);
            responseMsg.setMsg("请勿重复选课");
        }else {
            responseMsg.setFig(0);
            responseMsg.setMsg("选课失败");
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
