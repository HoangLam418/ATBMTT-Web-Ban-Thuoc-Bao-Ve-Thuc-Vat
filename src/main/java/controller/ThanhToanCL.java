package controller;

import Service.IProductService;
import Service.OrderDetailService;
import Service.OrderService;
import bean.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "ThanhToanCL", value = "/ThanhToanCL")
public class ThanhToanCL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý logic khi người dùng truy cập trang thanh toán
        // Ví dụ: Load danh sách địa chỉ giao hàng, thông tin thanh toán, ...
        HttpSession session = request.getSession();

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String city = request.getParameter("city");
        String xa = request.getParameter("xa");
        String noiO = request.getParameter("noiO");
        String phone = request.getParameter("phone");

        User user = (User) session.getAttribute("user");

        if(user != null) {
            if((firstName != null || !firstName.isEmpty())
                    && (lastName != null || !lastName.isEmpty())
                    && (city != null || !city.isEmpty())
                    && (xa != null || !xa.isEmpty())
                    && (noiO != null || !noiO.isEmpty())
                    && (phone != null || !phone.isEmpty())){
                Order order = new Order(firstName, lastName, city, xa, noiO, phone);
                OrderService orderService = new OrderService();
                orderService.add(order, user.getId());
                doPost(request,response);
            }else {
                request.getRequestDispatcher("FailCheck.jsp").forward(request,response);
            }
        }else{
            request.getRequestDispatcher("HomePageController").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gọi đến phương thức checkout trong ShoppingCartCL để xử lý đặt hàng
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
        OrderDetailService dao = new OrderDetailService();
        if(shoppingCart == null){
            request.getRequestDispatcher("FailCheck.jsp").forward(request,response);
        }else{
            for(CartItem list : shoppingCart.getCartItemList()){
                dao.add(list, user.getId());
            }
            response.sendRedirect("thanh-toan.jsp");
        }

    }
}
