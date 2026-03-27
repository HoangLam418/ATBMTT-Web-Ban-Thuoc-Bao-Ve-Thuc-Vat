package controller;

import Service.SendingEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/sendTextEmail")
public class SendEmailControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String message = req.getParameter("emailContent");

        HttpSession session = req.getSession();

        if((fullname != null || !fullname.isEmpty()) && (email != null || !email.isEmpty()) && (message != null || !message.isEmpty())){
            SendingEmail se = new SendingEmail(email);
            String strEmail = se.sendTextEmail(message, fullname);
            if(strEmail.equals("success")){
                String notify = "Cảm ơn bạn đã liên hệ với chúng tôi, chúng tôi sẽ phản hồi lại sau";
                session.setAttribute("notifySendTextEmail", notify);
                resp.sendRedirect("lien-he.jsp");
            }
        }else{
            String notify = "Bạn chưa nhập đầy đủ thông tin";
            session.setAttribute("notifySendTextEmailError", notify);
            resp.sendRedirect("lien-he.jsp");
        }
    }
}
