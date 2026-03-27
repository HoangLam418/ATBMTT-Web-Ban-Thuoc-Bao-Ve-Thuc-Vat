package controller;

import Service.IProductService;
import Service.ProductService;
import bean.Category;
import bean.Product;
import bean.Products;
import dao.CategoryDAO;
import dao.IProductDAO;
import dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomePageController", value = "/HomePageController")
public class HomePageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProductService productService = new ProductService();
        IProductDAO proDAO = new ProductDAO();
        CategoryDAO dao = new CategoryDAO();
        List<Category> cateList = new ArrayList<>();
        List<Products> products = new ArrayList<>();
        List<Product> products2 = new ArrayList<>();
        List<Products> productsNew1 = new ArrayList<>();
        List<Products> productsNew2 = new ArrayList<>();
        List<Products> findDiscountPro1 = new ArrayList<>();
        List<Products> findDiscountPro2 = new ArrayList<>();

        try {
            cateList = dao.getList();
            products = productService.findAll1();
            products2 = productService.findAll2();
            productsNew1 = proDAO.findNewPro1();
            productsNew2 = proDAO.findNewPro2();
            findDiscountPro1 = proDAO.findDiscountPro1();
            findDiscountPro2 = proDAO.findDiscountPro2();
        } catch (Exception ignored) {
            // Keep empty lists so homepage UI can still render without DB.
        }

        request.setAttribute("category", cateList);
        request.setAttribute("products", products);
//        request.setAttribute("products2", products2);
        request.setAttribute("productsNew1", productsNew1);
        request.setAttribute("productsNew2", productsNew2);
        request.setAttribute("findDiscountPro1", findDiscountPro1);
        request.setAttribute("findDiscountPro2", findDiscountPro2);
        String url = "index.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}