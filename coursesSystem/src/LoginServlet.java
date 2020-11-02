import com.google.gson.Gson;
import dao.accountDao.AccountDao;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginCheck")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String account_id = request.getParameter("username");
        String password = request.getParameter("password");

        Account account = new Account();
        account.setAccountId(account_id);
        account.setPassword(password);

        AccountDao accountDao = new AccountDao();
        ResponseMsg responseMsg = new ResponseMsg();

        List<Account> list =accountDao.query(account);
        if (!list.isEmpty()){
            Account validAccount = list.get(0);
            if (validAccount.getPassword().equals(password)){
                responseMsg.setFig(1);
                responseMsg.setMsg("登录成功");
                switch (validAccount.getPersonType()){
                    case 1://学生
                        responseMsg.setData("http://localhost:8080/coursesSystem_war_exploded/student/selectCourse" +
                                "?username=" + account_id);
                        break;
                    case 2://老师
                        responseMsg.setData("http://localhost:8080/coursesSystem_war_exploded/");
                        break;
                    case 3://root
                        responseMsg.setData("http://localhost:8080/coursesSystem_war_exploded/root/root.html");
                        break;
                }
            }else{
                responseMsg.setFig(0);
                responseMsg.setMsg("密码不正确");
            }
        }else{
            responseMsg.setFig(0);
            responseMsg.setMsg("账号不正确");
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
