package Service;

import bean.Order;
import db.DBContext;

import java.sql.*;
import java.sql.SQLException;
public class OrderService {


    public static OrderService add(Order order, int idUser){
        String sql = "INSERT orders(first_name, last_name, city, ward, address, phone, id_user) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DBContext.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, order.getFirst_name());
            ps.setString(2, order.getLast_name());
            ps.setString(3, order.getCity());
            ps.setString(4, order.getWard());
            ps.setString(5, order.getAddress());
            ps.setString(6, order.getPhone());
            ps.setInt(7, idUser);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}