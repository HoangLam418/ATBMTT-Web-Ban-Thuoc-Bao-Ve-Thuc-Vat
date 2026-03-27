package controller.Product;//package controller.Product;
//
//import Service.CategoryService;
//import Service.ProductServirce;
//import Service.UserService;
//import bean.Category;
//import bean.Product;
//import dao.ProductDao;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "Store", value = "/store")
//public class Store extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String pageID =req.getParameter("pageID");
//        if(pageID==null){
//            pageID="1";
//        }
//        int pageIDInt=Integer.parseInt(pageID);
//
//        List<Category>listCat= CategoryService.getInstance().listCate();
//        List<Product>list12Pro= ProductServirce.getInstance().selectTwelve(pageIDInt);
//        req.setAttribute("listPro",list12Pro);
//        req.setAttribute("listCat",listCat);
//
//        //==========số trang trên strore===================================
//        int Num= ProductServirce.getInstance().selectAllPro();
//        int endPage=Num/12;
//        if(Num%12 !=0){
//            endPage++;
//        }
//        req.setAttribute("endPage",endPage);
//        //==========số trang dựa trên category=============================
//        req.getRequestDispatcher("./cuahang.jsp").forward(req,resp);
//    }
//}