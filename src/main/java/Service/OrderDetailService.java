package Service;

import bean.CartItem;
import bean.Order;
import bean.OrderDetail;
import bean.Product;
import db.DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailService {
    static final String DB_URL = "jdbc:mysql://localhost/test";
    static final String USER = "root";
    static final String PASS = "";

    public static String add(CartItem orderDetail, int userID){
        String sql = "INSERT order_detail(product_id, quantity, price, id_user) VALUES (?, ?, ?, ?)";
        Connection conn = DBContext.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderDetail.getProduct().getId());
            ps.setInt(2, orderDetail.getQuantity());
            ps.setDouble(3, orderDetail.getTotalPrice());
            ps.setInt(4, userID);
            int i = ps.executeUpdate();

            if(i != 0){
                return "success";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return null;
    }
}
