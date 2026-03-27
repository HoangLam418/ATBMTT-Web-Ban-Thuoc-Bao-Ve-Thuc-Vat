package controller;

import Service.ProductsService;

import javax.lang.model.element.Name;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteProduct",value = "/deletePro")
public class DeleteProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String proID = req.getParameter("proID");
        String page = req.getParameter("page");
        int proIDint= 0;
        if(proID!= null && !proID.isEmpty()){
            proIDint=Integer.parseInt(proID);
        }
        ProductsService.getInstance().deleteProduct(proIDint);
        resp.sendRedirect("./maProduct?proID="+page);
    }
}
