package accountOptServlet;

import com.google.gson.Gson;
import dao.accountDao.AccountDao;
import dao.courseDao.CourseDao;
import data.account.Account;
import data.course.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QueryAllAccountsServlet", urlPatterns = "/queryAllAccounts")
public class QueryAllAccountsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            AccountDao dao = new AccountDao();
            List<Account> accounts = dao.queryAll();

            Gson gson = new Gson();
            String jsonString = gson.toJson(accounts);
            System.out.println(jsonString);

            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.append(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
