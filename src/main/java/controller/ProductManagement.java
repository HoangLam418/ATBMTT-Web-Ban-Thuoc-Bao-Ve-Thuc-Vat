package controller;

import Service.ProductsService;
import bean.Product;
import bean.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductManagement", value = "/maProduct")
public class ProductManagement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        if(search==null){
            search="";
        }
//        System.out.println("search:"+search);
        int pageChose=1;
        String proID= req.getParameter("proID");
        if(proID != null && !(proID.isEmpty())){
            try {
                pageChose=Integer.parseInt(proID);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        List<Products>getTenPro= ProductsService.getInstance().getTenPro(pageChose,search);// ds 10 sp
        List<Products> listPro=ProductsService.getInstance().productList(search);//ds toàn bộ sp
        req.setAttribute("tag",pageChose);
        req.setAttribute("getTenPro",getTenPro);
        int numAllPro= listPro.size();// lấy ra số lượng của tất cả sản phẩm.
        int page= numAllPro/10;
        if(numAllPro%10 != 0){
            page++;
        }
        req.setAttribute("page",page);
        req.getRequestDispatcher("admin_page/quanlyProduct.jsp").forward(req,resp);
    }
}
