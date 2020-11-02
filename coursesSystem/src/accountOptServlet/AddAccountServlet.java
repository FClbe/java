package accountOptServlet;

import com.google.gson.Gson;
import dao.accountDao.AccountDao;
import dao.courseDao.CourseDao;
import data.account.Account;
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

@WebServlet(name = "AddAccountServlet", urlPatterns = "/addAccountServlet")
public class AddAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        System.out.println("-------------请求添加账号-----------------");
        //courseId, name, learningTime, learningScore, place, maxSelectedNum, teacher
        String accountId = request.getParameter("accountId");

        String password = request.getParameter("password");
        int personType = Integer.parseInt(request.getParameter("personType"));

        //构造存储对象
        Account account = new Account();
        account.setAccountId(accountId);
        account.setPassword(password);
        account.setPersonType(personType);

        //利用CourseDao存进数据库
        AccountDao dao = new AccountDao();
        ResponseMsg responseMsg = new ResponseMsg();

        if(dao.insert(account) == 1){
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
