package controller;

import Service.SendingEmail;
import bean.User;
import dao.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/PasswordForgot")
public class ForgotPassControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login-register/forgot_password.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        HttpSession session = req.getSession();

        AccountDAO dao = new AccountDAO();
        User user = dao.checkAccountExist(email);
        if(user == null){
            String error = "Nhập sai email hoặc email không tồn tại ";
            session.setAttribute("error", error);
            resp.sendRedirect("PasswordForgot?action=forget-page");
        }else{
            SendingEmail se = new SendingEmail(email);
            se.sendFPassByEmail();
            resp.sendRedirect("verify.jsp");
            session.removeAttribute("error");
        }
    }
}
