package controller;

import Service.UserService;
import bean.User;
import dao.UserDAO;
import org.springframework.util.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InsertUser",value = "/insertUser")
public class InsertUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username= req.getParameter("username");
        String lastname= req.getParameter("lastname");
        String surname= req.getParameter("surname");
        String email =req.getParameter("email");
        String pass= req.getParameter("pass");
        String newPass= DigestUtils.md5DigestAsHex(pass.getBytes());
        String phone= req.getParameter("phone");
        User a = UserDAO.getUserByEmail(email);
        System.out.println(a);
        if(a != null){
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Người dùng đã tồn tại. Vui lòng chọn email khác.');");
            out.println("window.location.href='./maUser';");  // Điều hướng về trang form
            out.println("</script>");
        } else {
            UserService.getInstance().insertUser(email,newPass,username,1,surname,lastname,phone,"",1);
            resp.sendRedirect("./maUser?roleID=1&uid=1");
        }
    }
}
