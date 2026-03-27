package controller;

// ... your code ...


import Service.IProductService;
import Service.ProductService;
import bean.Comment;
import bean.Products;
import bean.User;
import dao.CommentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/ProductInfor")
public class ProductInfor extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_product = request.getParameter("id_product");
        Products proID = null;
        List<Comment> comments = new ArrayList<>();

        try {
            if(id_product != null){
                int id = Integer.parseInt(id_product);
                IProductService pro = new ProductService();
                proID = pro.findById(id);
            }

            CommentDAO dao = new CommentDAO();
            comments = dao.getAllComments();
        } catch (Exception ignored) {
            proID = null;
            comments = new ArrayList<>();
        }

        int count = comments.size();
        request.setAttribute("proID", proID);
        request.setAttribute("comments", comments);
        request.setAttribute("commentCount", count);

        request.getRequestDispatcher("thong-tin-don-hang.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String commentText = request.getParameter("commentText");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(user != null){
            Comment comment = new Comment();
            comment.setUsername(username);
            comment.setCommentText(commentText);
            comment.setEmail(user.getEmail());

            CommentDAO dao = new CommentDAO();
            dao.addComment(comment);

            response.sendRedirect(request.getContextPath() + "/ProductInfor");
        }else{
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
