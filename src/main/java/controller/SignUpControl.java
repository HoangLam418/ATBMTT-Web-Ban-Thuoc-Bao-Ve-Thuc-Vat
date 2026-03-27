package controller;

import Service.SendingEmail;
import bean.User;
import dao.AccountDAO;
import org.apache.commons.codec.cli.Digest;
import org.springframework.util.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = {"/signup"})
public class SignUpControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login-register/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String surname = req.getParameter("surname");
        String lastname = req.getParameter("lastname");
        String phone = req.getParameter("phone");
        String pass = req.getParameter("pass");
        String re_pass = req.getParameter("rePass");
        String hashpass = DigestUtils.md5DigestAsHex(pass.getBytes());

        HttpSession session = req.getSession();

        String myHash ;
        Random random = new Random();
        random.nextInt(999999);
        myHash = DigestUtils.md5DigestAsHex((""+random).getBytes());

        User user = new User();
//        user.setHash(myHash);
//        user.setEmail(email);
//        user.setLastname(lastname);
//        user.setSurname(surname);
//        user.setUsername(username);
//        user.setPhone(phone);
//        user.setPassword(hashpass);

        if(!pass.equals(re_pass)){
            req.getRequestDispatcher("signup").forward(req,resp);
        }else{
            AccountDAO acc = new AccountDAO();
            user = acc.checkAccountExist(email);
            if(user == null){
                if(phone.length() == 10){
                    String str = acc.signUp( email, hashpass, username, surname, lastname, phone, myHash);
                    if(str.equals("success")){
                        SendingEmail se = new SendingEmail(email, myHash);
                        se.sendMail();
                        String error = "Kích hoạt email để đăng nhập";
                        session.setAttribute("errorRegis", error);
                        resp.sendRedirect("login");
                    }else{
                        String error = "Đăng ký thất bại ";
                        session.setAttribute("errorRegis", error);
                        resp.sendRedirect("signup");
                        }
                    }else{
                    String error = "Tối thiểu 10 số ";
                    session.setAttribute("errorNumber", error);
                    resp.sendRedirect("signup");
                }
                }else{
                    req.getRequestDispatcher("register.jsp").forward(req,resp);
                }
            }
        }
    }
