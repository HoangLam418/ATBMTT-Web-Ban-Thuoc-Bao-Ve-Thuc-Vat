package dao;

import bean.User;
import db.DBContext;
import db.JDBIConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDAO {

    public String userChangeInfo(String surname, String lastname, String username, String phone,String email){
        Connection conn = DBContext.getConnection();
        String sql = "update users set surname=? , lastname=? , username=? , phone=? where email=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, surname);
            ps.setString(2, lastname);
            ps.setString(3, username);
            ps.setString(4, phone);
            ps.setString(5, email);

            int i = ps.executeUpdate();

            if(i > 0) return "success";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String userChangePassword(String email ,String newPassword){
        Connection conn = DBContext.getConnection();
        String sql = "update users set password = ? where email = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, email);

            int i = ps.executeUpdate();
            if(i > 0) return "success";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //1. lấy người dùng theo email. đã check
    public static User getUserByEmail(String email){
        Optional<User> user = JDBIConnector.getJdbi().withHandle((handle ->
                handle.createQuery("select id,username,password,phone,email,surname,lastname,role,hash,active from users where email = ?")
                        .bind(0,email)
                        .mapToBean(User.class).stream().findFirst()
        ));
        return user.isEmpty() ? null : user.get();
    }
  //2. lấy người dùng theo id. đã check
    public static User selectUser(int id){
        Optional<User> user = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("select id,username,password,phone,email,surname,lastname,role,hash,active from users where id = ?")
                        .bind(0, id)
                        .mapToBean(User.class).stream().findFirst());
        return user.isEmpty() ? null : user.get();
    }

//    //3. lấy ra all user. đã check
    public static List<User> dsUsers(){
        List<User> users = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("select id,username,password,phone,email,surname,lastname,role,hash,active from users").mapToBean(User.class).collect(Collectors.<User>toList()));
        return users;
    }
//    //xóa ng dùng theo email.đã check
    public static void deleteUser(int id){// đã check
        JDBIConnector.getJdbi().useHandle(handle ->
                handle.createUpdate("DELETE FROM users WHERE id = ?")
                        .bind(0,id)
                        .execute());
    }
//    // thêm người dùng.đẫ check
    public static void insertUser(String email, String pass, String username, int role, String surname, String lastname, String phone, String hash, int active) {
        JDBIConnector.getJdbi().useHandle(handle ->
                handle.createUpdate("INSERT INTO users(email, password, username, role, surname, lastname, phone, hash, active) VALUES (?,?,?,?,?,?,?,?,?)")
                        .bind(0, email)
                        .bind(1, pass)
                        .bind(2, username)
                        .bind(3, role)
                        .bind(4, surname)
                        .bind(5, lastname)
                        .bind(6, phone)
                        .bind(7, hash)
                        .bind(8, active)
                        .execute()
        );
    }
    //
////    UPDATE `users` SET `email`='dinhvu@gmail.com',`pass`='123dc',`name`='Dinh Vu',`role`=0 WHERE`id`=2;
    // thay đổi thông tin người dùng.
    public static void updateUser(String surname,String lastname,String username,String phone,int active,int id) {
        JDBIConnector.getJdbi().useHandle(handle ->
                handle.createUpdate("UPDATE users SET surname=?,lastname=?,username=?,phone=?,active=? WHERE id=?")
                        .bind(0,surname)
                        .bind(1,lastname)
                        .bind(2,username)
                        .bind(3,phone)
                        .bind(4,active)
                        .bind(5,id)
                        .execute()
        );
    }

//// kiểm tra người dùng tồn tại.nếu người dùng ko tồn tại false và ngc lại
    public static boolean isUserExists(String email) {
        User a= UserDAO.getUserByEmail(email);
        return a !=null;
    }
//
   // lấy ra số lượng của của từng vai trò
    public static int numOfRole(int role,String search){
        Integer integer = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT COUNT(*)  FROM users where role=? AND (lastname LIKE ? OR username LIKE ?)")
                        .bind(0,role)
                        .bind(1, "%" + search + "%")
                        .bind(2, "%" + search + "%")
                        .mapTo(Integer.class)
                        .one());
        return integer != null ?integer :0;
    }
//    // Lấy ra 10 người .
    public static List<User>selectTen(int index){
        List<User> users = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT id,username,password,phone,email,surname,lastname,role,hash,active FROM users\n" +
                                "ORDER BY id\n" +
                                "LIMIT 5 OFFSET ?")
                        .bind(0,(index - 1) * 5)
                        .mapToBean(User.class)
                        .collect(Collectors.toList()));
        return users;
    }
    // lấy ra 5 người theo role.
    public static List<User>listOfRole(int role,int index){
        List<User> users = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT id,role,username,password,phone,email" +
                                ",surname,lastname,hash\n" +
                                "FROM users\n" +
                                "WHERE role = ?\n" +
                                "ORDER BY id\n" +
                                "LIMIT 5 OFFSET ? ")
                        .bind(0,role)
                        .bind(1,(index-1)*5)
                        .mapToBean(User.class)
                        .collect(Collectors.toList()));
        return users;
    }
    public static List<User> listOfRoleWithSearch(int role, int index, String search) {
        List<User> users = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT id, role, username, password, phone, email"+
                                ",surname,lastname,hash\n" +
                                "FROM users\n" +
                                "WHERE role=? AND (lastname LIKE ? OR username LIKE ?)\n" +
                                "ORDER BY id\n" +
                                "LIMIT 5\n" +
                                "OFFSET ? ")
                        .bind(0, role)
                        .bind(1, "%" + search + "%")
                        .bind(2, "%" + search + "%")
                        .bind(3, (index - 1) * 5)
                        .mapToBean(User.class)
                        .collect(Collectors.toList()));
        return users;
    }


    public static void main(String[] args) {
//        for(User a: UserDAO.listOfRoleWithSearch(0,1,"")){
//            System.out.println(a);
//        }
//        for(User a: UserDAO.listOfRole(0,1)){
//            System.out.println(a);
//        }
//        UserDAO.updateUser("Trung Kiên","Nguyễn","TrKien","0932493567",1,8);
//        System.out.println(UserDAO.numOfRole(0,"tu"));
        UserDAO.insertUser("thDung@gmail.com","dfsdf","dfsd",1,"sdfs","dfg","0098238","",1);
    }
}
