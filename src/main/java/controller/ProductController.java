package controller;

import Service.IProductService;
import Service.ProductService;
import Service.ProductsService;
import bean.Product;
import bean.Products;
import dao.IProductDAO;
import dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String idCate = request.getParameter("id_category");

        List<Products> list = new ArrayList<>();
        try {
            if (idCate == null) {
                idCate = "";
                list = ProductsService.getInstance().findAll1(idCate);
            } else {
                int cateId = Integer.parseInt(idCate);
                list = ProductsService.getInstance().findByCategory(cateId, "");
                session.setAttribute("idCate", idCate);
            }

            IProductDAO dao = new ProductDAO();
            String order = request.getParameter("order");
            if(order != null){
                int orderValue = Integer.parseInt(order);
                if(orderValue == 2){
                    list = dao.findByPriceMin("");
                }else if(orderValue == 3){
                    list = dao.findByPriceMax("");
                }
            }
        } catch (Exception ignored) {
            list = new ArrayList<>();
        }

        request.setAttribute("products", list);
        request.getRequestDispatcher("cuahang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String search = request.getParameter("search");

        int id = 0;
        Object idCateObj = session.getAttribute("idCate");
        if (idCateObj != null) {
            id = Integer.parseInt(idCateObj.toString());
        }

        if (search == null) {
            search = "";
        }

        List<Products> list = new ArrayList<>();
        try {
            if (id == 0) {
                list = ProductsService.getInstance().findAll1(search);
            } else {
                list = ProductsService.getInstance().findByCategory(id, search);
            }
        } catch (Exception ignored) {
            list = new ArrayList<>();
        }

        request.setAttribute("products", list);
        request.getRequestDispatcher("cuahang.jsp").forward(request, response);
    }
}