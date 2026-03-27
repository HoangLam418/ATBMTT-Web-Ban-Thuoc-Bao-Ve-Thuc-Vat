package controller;

import CKeditor.HtmlUtils;
import Service.CategoryService;
import Service.ProductsService;
import bean.Category;
import bo.CategoryBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.math.BigDecimal;

@WebServlet(name="InsertProduct", value = "/insertPro")
@MultipartConfig(
        fileSizeThreshold = 1024*1024,// 1MB
        maxFileSize = 1024*1024*10, //10MB
        maxRequestSize = 1024*1024*100 //100MB

)

public class InsertProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("admin_page/addProduct.jsp").forward(req,resp);
        CategoryBO bo = new CategoryBO();
        List<Category>allCate= bo.getListCategory();
        req.setAttribute("allCate",allCate);
        String finalPage= req.getParameter("finalPage");
        HttpSession session =req.getSession();
        session.setAttribute("endPage",finalPage);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session =req.getSession();
        String finalPage= (String) session.getAttribute("endPage");

        String productName = req.getParameter("productName");
        String categoryId = req.getParameter("productCate");
        int intCategoryId = 0;
        if (categoryId != null && !categoryId.isEmpty()) {
            intCategoryId = Integer.parseInt(categoryId);
        }
        String quantity=req.getParameter("productNum");
        int num=0;
        if(quantity != null && !quantity.isEmpty()){
            num= Integer.parseInt(quantity);
        }
        Part filePart = req.getPart("imageFile");
        String price = req.getParameter("price");
        int priceInt = 0; // Khai báo priceInt ở đây để nó có thể được sử dụng ở bất kỳ đâu trong phương thức
        try {
            String numericString = price.replace(".", "");
            BigDecimal numericValue = new BigDecimal(numericString);
            priceInt = numericValue.intValue();
            System.out.println(priceInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String active = req.getParameter("active");
//        System.out.println(active);
        int activeInt=0;
        try {
            if(active.equals("Mở bán")) {
                activeInt = 1;
            }else{
                if (active.equals("Hủy bán")){
                    activeInt=0;
                }
            }
//            System.out.println(activeInt);
        } catch (ArithmeticException e) {
        }
        String specifications =HtmlUtils.removeHtmlTags(req.getParameter("specifications")) ;
        String proDesc =HtmlUtils.removeHtmlTags(req.getParameter("proDesc")) ;
        String fileName = filePart.getSubmittedFileName();
        String root = getServletContext().getRealPath("/dataImages/");
        File check = new File(root);
        if (!(check.exists()))
            check.mkdirs();
        if (filePart != null) {
            filePart.write(root + fileName);
        }
        String imagePath="dataImages/"+fileName;
        //insertProduct(String name, String picture, int price, int category, int quantity, int status, String specifications, String desc)
        ProductsService.getInstance().insertProduct(productName,imagePath,priceInt,intCategoryId,num,activeInt,specifications,proDesc);
        resp.sendRedirect("./maProduct?proID="+finalPage);
    }
}
