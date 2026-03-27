package controller;

import Service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditCategory",value = "/editCategory")
public class EditCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String categoryName= req.getParameter("categoryName");
        String categoryId = req.getParameter("categoryId");
        int intCategoryId=0;
        if(categoryId!= null && !categoryId.isEmpty()){
            intCategoryId =Integer.parseInt(categoryId);
        }
        CategoryService.getInstance().updateCategory(categoryName,intCategoryId);
        resp.sendRedirect("./maCategory");
    }
}
