package controller;

import Service.CategoryService;
import bean.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryManagement",value = "/maCategory")
public class CategoryManagement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search=req.getParameter("search");
        if (search == null) {
            search = "";
        }
        List<Category> listCategory= CategoryService.getInstance().listCategory(search,0);
        req.setAttribute("listCategory",listCategory);
        req.getRequestDispatcher("admin_page/quanlyCategory.jsp").forward(req,resp);
    }
}
