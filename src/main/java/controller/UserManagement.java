package controller;

import Service.UserService;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserManagement", value = "/maUser")
public class UserManagement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String roleID = req.getParameter("roleID");
        String uid = req.getParameter("uid");
        String search= req.getParameter("search");

        // Kiểm tra giá trị roleID và uid trước khi chuyển đổi
        int roleInt = 0;  // Giá trị mặc định là 0
        int uidInt = 1;   // Giá trị mặc định là 1
        if (search == null) {
            search = "";
        }

        if (roleID != null && !roleID.isEmpty()) {
            try {
                roleInt = Integer.parseInt(roleID);
            } catch (NumberFormatException e) {
                // Xử lý ngoại lệ nếu chuyển đổi thất bại
                e.printStackTrace(); // Hoặc sử dụng một phương tiện khác để ghi log
                // Có thể thêm thông báo lỗi vào req để hiển thị trên trang quanlyuser.jsp
                req.setAttribute("error", "Invalid roleID. Please enter a valid number.");
            }
        }

        if (uid != null && !uid.isEmpty()) {
            try {
                uidInt = Integer.parseInt(uid);
            } catch (NumberFormatException e) {
                // Xử lý ngoại lệ nếu chuyển đổi thất bại
                e.printStackTrace(); // Hoặc sử dụng một phương tiện khác để ghi log
                // Có thể thêm thông báo lỗi vào req để hiển thị trên trang quanlyuser.jsp
                req.setAttribute("error", "Invalid uid. Please enter a valid number.");
            }
        }

        // Khởi tạo 1 biến roleInt2 bằng với roleInt
        int roleInt2 = roleInt;
        req.setAttribute("roleInt2", roleInt2);

        // Lấy ra số lượng khách hàng
        int num = UserService.getInstance().numOfRole(roleInt,search);
        int endPage = num / 5;
        if (num % 5 != 0) {
            endPage++;
        }
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", uidInt);

        List<User> dsUser = UserService.getInstance().listOfRoleWithSearch(roleInt,uidInt,search);
//        List<User> dsUser = UserService.getInstance().listOfRole(roleInt, uidInt);
        req.setAttribute("dsUser", dsUser);

        // Chuyển hướng đến trang quanlyuser.jsp (dù có lỗi hay không)
        req.getRequestDispatcher("admin_page/quanlyuser.jsp").forward(req, resp);
    }
}
