package dao;

import bean.Product;
import bean.Products;
import db.JDBIConnector;
import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDAO implements IProductDAO {
    private Connection conn;
    @Override
    public List<Products> findAll1() {
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Products> products = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM product";
            return handle.createQuery(sql).mapToBean(Products.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    @Override
    public List<Product> findAll2() {
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Product> products2 = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM products2";
            return handle.createQuery(sql).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products2;
    }

    @Override
    public List<Products> findNewPro1() {
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Products> findNewPro1 = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM product\n" +
                    "order by create_at desc\n" +
                    "LIMIT 3;";
            return handle.createQuery(sql).mapToBean(Products.class).stream().collect(Collectors.toList());
        });
        return findNewPro1;
    }

    @Override
    public List<Products> findNewPro2() {
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Products> findNewPro2 = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM product\n" +
                    "order by create_at desc\n" +
                    "LIMIT 3 OFFSET 3;";
            return handle.createQuery(sql).mapToBean(Products.class).stream().collect(Collectors.toList());
        });
        return findNewPro2;
    }

    @Override
    public List<Products> findDiscountPro1() {
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Products> findNewPro1 = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM product\n" +
                    "where activeDisplay = 1\n" +
                    "order by activeDiscount desc\n" +
                    "LIMIT 3;";
            return handle.createQuery(sql).mapToBean(Products.class).stream().collect(Collectors.toList());
        });
        return findNewPro1;
    }

    @Override
    public List<Products> findDiscountPro2() {
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Products> findNewPro2 = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM product\n" +
                    "where activeDisplay = 1\n" +
                    "order by activeDiscount desc\n" +
                    "LIMIT 3 OFFSET 3;";
            return handle.createQuery(sql).mapToBean(Products.class).stream().collect(Collectors.toList());
        });
        return findNewPro2;
    }

    @Override
    public List<Products> findById(int id) {
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Products> products = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM product where id=?";
            return handle.createQuery(sql).bind(0, id).mapToBean(Products.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    @Override
    public List<Products> findByPriceMax(String id) {
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Products> products = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM product\n" +
                    "where id_category like ? " + // Added space here
                    "order by price desc";
            return handle.createQuery(sql).bind(0, "%" + id + "%").mapToBean(Products.class).list();
        });
        return products;
    }

    @Override
    public List<Products> findByPriceMin(String id) {
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Products> products = jdbi.withHandle(handle -> {
            String sql = "SELECT * FROM product\n" +
                    "where id_category like ? " + // Added space here
                    "order by price asc";
            return handle.createQuery(sql).bind(0, "%" + id + "%").mapToBean(Products.class).list();
        });
        return products;
    }


    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        dao.findByPriceMin("").forEach(System.out::println);
    }
}
