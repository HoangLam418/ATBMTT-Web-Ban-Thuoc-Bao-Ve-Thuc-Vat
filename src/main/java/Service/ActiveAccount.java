package Service;

import dao.AccountDAO;
import db.DBContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/ActiveAccount")
public class ActiveAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("key1");
        String hash = req.getParameter("key2");
//        Connection con = DBContext.getConnection();
//
//        try {
//            PreparedStatement ps = con.prepareStatement("select email, hash, active from users where email = ? and hash = ? and active = 0");
//            ps.setString(1, email);
//            ps.setString(2, hash);
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//                PreparedStatement ps1 = con.prepareStatement("update users set active = 1 where email = ? and hash = ?");
//                ps1.setString(1, email);
//                ps1.setString(2, hash);
//                int i = ps1.executeUpdate();
//                if(i == 1){
//                    resp.sendRedirect("login_register.jsp");
//                }else{
//                    resp.sendRedirect("index.jsp");
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        AccountDAO dao = new AccountDAO();
        String str = dao.activeAccount(email, hash);
        if(str.equals("success")){
            resp.sendRedirect("login?action=login");
        }else{
            resp.sendRedirect("signup?action=register");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
