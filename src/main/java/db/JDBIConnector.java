package db;

import bean.Product;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class JDBIConnector {
    public static Jdbi jdbi;

    public static Jdbi getJdbi() {
        if (jdbi == null) {
            connect();
        }
        return jdbi;
    }

    public static void connect() {
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setURL("jdbc:mysql://" + DBProperties.host + ":" + DBProperties.port + "/" + DBProperties.dbName +
                "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&connectTimeout=1000&socketTimeout=2000");
        dataSource.setUser(DBProperties.username);
        dataSource.setPassword(DBProperties.password);
        try {
            dataSource.setAutoReconnect(false);
            dataSource.setUseCompression(true);
            dataSource.setConnectTimeout(1000);
            dataSource.setSocketTimeout(2000);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jdbi = Jdbi.create(dataSource);
    }

    public static void main(String[] args) {
        Jdbi jdbi = JDBIConnector.getJdbi();

        // Lấy dữ liệu từ table products
        List<Product> products = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM products";
            return handle.createQuery(sql).mapToBean(Product.class).stream().collect(Collectors.toList());
        });

        // Lấy dữ liệu từ table products2
        List<Product> products2 = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM products2";
            return handle.createQuery(sql).mapToBean(Product.class).stream().collect(Collectors.toList());
        });

        // In ra kết quả
        System.out.println("Products from 'products' table: " + products);
        System.out.println("Products from 'products2' table: " + products2);
    }
}
