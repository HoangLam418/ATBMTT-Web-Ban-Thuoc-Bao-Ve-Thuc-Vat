package controller;

import Service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategory", value = "/deleteCate")
public class DeleteCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cateID =req.getParameter("cateID");
        int intCateID=0;
        if((cateID!= null) && (!cateID.isEmpty()) ){
            intCateID= Integer.parseInt(cateID);
        }
        CategoryService.getInstance().deleteCategory(intCateID);
        resp.sendRedirect("./maCategory");
    }
}
