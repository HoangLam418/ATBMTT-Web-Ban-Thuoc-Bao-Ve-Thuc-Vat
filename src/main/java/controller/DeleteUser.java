package controller;

import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUser",value = "/deleteUser")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID= req.getParameter("userID");
        int userIDInt=0;
        if (userID != null && !userID.isEmpty()) {
            try {
                userIDInt = Integer.parseInt(userID);
            } catch (NumberFormatException e) {
                return;  // Kết thúc phương thức nếu có lỗi
            }
        }
        System.out.println(userIDInt);
        String page = req.getParameter("page");
        String role=req.getParameter("role");
        UserService.getInstance().deleteUser(userIDInt);
        resp.sendRedirect("./maUser?roleID=" +role +"&uid="+page);
    }
}
