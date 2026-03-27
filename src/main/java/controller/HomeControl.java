package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/home", "/admin-home"})
public class HomeControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
       if(action != null && action.equals("home")){
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } else if(action != null && action.equals("admin")){
            req.getRequestDispatcher("admin_page/admin.jsp").forward(req,resp);
        } else {
            // Trường hợp action không được xác định, có thể xử lý hoặc trả về lỗi 404
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
