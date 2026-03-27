package controller;

import Service.UserService;
import bean.User;
import org.springframework.util.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="UserEdit",value = "/editUser")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userID= req.getParameter("userID");
        String tag =req.getParameter("tag");
        String role=req.getParameter("role");
        //Khai báo session.
        HttpSession session = req.getSession();
        session.setAttribute("tag", tag);
        session.setAttribute("role", role);

        int usidInt=0;
        if((userID!=null) && (!userID.isEmpty())){
            usidInt=Integer.parseInt(userID);
        }
        User userEdit=UserService.getInstance().selectUser(usidInt);
        req.setAttribute("user",userEdit);

        req.getRequestDispatcher("admin_page/editUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userID=req.getParameter("userID");
        // lấy ra số trang và role
        HttpSession session = req.getSession();
        String tag = (String) session.getAttribute("tag");
        String role = (String) session.getAttribute("role");

        int intuserID=0;
        if (userID != null && !userID.isEmpty()) {
            intuserID = Integer.parseInt(userID);
        }
        User oldUser= UserService.getInstance().selectUser(intuserID);
        String surname= req.getParameter("surname");
        String lastname= req.getParameter("lastname");
        String username =req.getParameter("username");
        String phone = req.getParameter("phone");
        String active = req.getParameter("active");
        if(surname==""){
            surname=oldUser.getSurname();
        }
        if(lastname== ""){
            lastname=oldUser.getLastname();
        }
        if(username== ""){
            username=oldUser.getUsername();
        }
        if(phone== ""){
            phone=oldUser.getPhone();
        }
        int intActive=0;
        if (active!=null && !active.isEmpty()){
            if(active.equals("Kích hoạt tài khoản")) {
                intActive = 1;
            }else{
                intActive =0;
            }
        }
//        resp.getWriter().println(intuserID);
//        resp.getWriter().println(surname);
//        resp.getWriter().println(lastname);
//        resp.getWriter().println(username);
//        resp.getWriter().println(phone);
//        resp.getWriter().println(intActive);
//        resp.getWriter().println(tag);
//        resp.getWriter().println(role);
//        int activeInt=0;
//        if(active != null && !active.isEmpty()) {
//            activeInt = Integer.parseInt(active);
//        }else{
//            activeInt=oldUser.getActive();
//        }
        //public void updateUser(String surname,String lastname,String username,String phone,int active,int id){
        //        UserDAO.updateUser(surname, lastname, username, phone, active, id);
        //    }

        UserService.getInstance().updateUser(surname,lastname,username,phone,intActive,intuserID);
        resp.sendRedirect("./maUser?roleID=" +role +"&uid="+tag);
    }
}
