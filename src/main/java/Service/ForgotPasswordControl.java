package Service;

import Service.SendingEmail;
import bean.User;
import dao.AccountDAO;
import org.springframework.util.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/ForgotPassword")
public class ForgotPasswordControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("key1");
        session.setAttribute("email", email);
        String action = req.getParameter("action");
        if(action != null && action.equals("createPass")){
            req.getRequestDispatcher("login-register/form_create_nPassword.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");

        String newPassword = req.getParameter("newPassword");
        String rePassword = req.getParameter("rePassword");

        String hashPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());

        AccountDAO dao = new AccountDAO();

        if((newPassword == null || newPassword.isEmpty()) || (rePassword == null || rePassword.isEmpty())){
            String passF = "Bạn nhập còn thiếu";
            session.setAttribute("passF", passF);
            req.getRequestDispatcher("login-register/form_create_nPassword.jsp").forward(req, resp);
        }

        if((newPassword != null && !newPassword.isEmpty()) || (rePassword != null && !rePassword.isEmpty())){
            if(newPassword.equals(rePassword)){
                String str = dao.forgetPassword(email, hashPassword);
                if(str.equals("Success")){
                    session.removeAttribute("passF");
                    String passF = "Đã cập nhật thành công mật khẩu";
                    session.setAttribute("passF", passF);
                    resp.sendRedirect("login?action=login");
                }else{
                    String passF = "Mời bạn nhập lại";
                    session.setAttribute("passF", passF);
                    req.getRequestDispatcher("login-register/form_create_nPassword.jsp").forward(req, resp);
                }
            }else {
                String passF = "Mật khẩu không giống nhau";
                session.setAttribute("passF", passF);
                req.getRequestDispatcher("login-register/form_create_nPassword.jsp").forward(req, resp);
            }
        }
    }
}

