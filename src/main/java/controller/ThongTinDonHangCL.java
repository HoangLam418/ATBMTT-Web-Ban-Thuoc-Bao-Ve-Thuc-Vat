package controller;

import Service.IProductService;
import Service.ProductService;
import bean.CartItem;
import bean.Product;
import bean.ShoppingCart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ThongTinDonHangCL", value = "/ThongTinDonHangCL")
public class ThongTinDonHangCL extends HttpServlet {
    IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showOrderDetails(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "delete":
                Delete(request, response);
                break;
            case "put":
                Put(request, response);
                break;
            default:
                // Xử lý trường hợp khác nếu cần
        }
    }

    private void showOrderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart shoppingCart;
        HttpSession session = request.getSession();
        shoppingCart = (ShoppingCart) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }
        session.setAttribute("cart", shoppingCart);

        request.getRequestDispatcher("thong-tin-don-hang.jsp").forward(request, response);
    }

    private void Put(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart shoppingCart;
        HttpSession session = req.getSession();
        shoppingCart = (ShoppingCart) session.getAttribute("cart");
        int id = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String e = "";
        if (quantity > 0) {
            shoppingCart.update(id, quantity);
        } else {
            e = "Số lượng phải lớn hơn 0";
        }
        req.setAttribute("error", e);
        session.setAttribute("cart", shoppingCart);
        req.getRequestDispatcher("ThongTinDonHangCL").forward(req, resp);
    }

    private void Delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart shoppingCart;
        HttpSession session = req.getSession();
        shoppingCart = (ShoppingCart) session.getAttribute("cart");
        int id = Integer.parseInt(req.getParameter("id"));
        shoppingCart.remove(id);
        session.setAttribute("cart", shoppingCart);
        resp.sendRedirect("thong-tin-don-hang.jsp");
    }
}
