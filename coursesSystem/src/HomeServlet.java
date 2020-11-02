import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;


public class HomeServlet extends javax.servlet.http.HttpServlet {
    private String message;

    public void init()
    {
        // 执行必需的初始化
        message = "Hello World";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {

        String string = request.getParameter("userID");
        System.out.println(string);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {


        // 设置响应内容类型
        response.setContentType("text/html");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }
}
