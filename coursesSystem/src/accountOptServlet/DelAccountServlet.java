package accountOptServlet;

import com.google.gson.Gson;
import dao.accountDao.AccountDao;
import dao.courseDao.CourseDao;
import data.account.Account;
import data.course.Course;
import data.responseMsg.ResponseMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DelAccountServlet", urlPatterns = "/delAccountServlet")
public class DelAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountId = request.getParameter("accountId");

        Account account = new Account();
        account.setAccountId(accountId);

        //利用CourseDao进行数据库操作
        AccountDao dao = new AccountDao();
        ResponseMsg responseMsg = new ResponseMsg();

        if(dao.delete(account) == 1){
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
