package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-product", "/admin-user", "/admin-order"})
public class AdminControl extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("qlsp")) {
            req.getRequestDispatcher("admin_page/quanlySP.jsp").forward(req, resp);
        } else if (action != null && action.equals("qldh")) {
            req.getRequestDispatcher("admin_page/quanlyDonHang.jsp").forward(req, resp);
        } else if (action != null && action.equals("qlnd")) {
            req.getRequestDispatcher("admin_page/quanlyuser.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
