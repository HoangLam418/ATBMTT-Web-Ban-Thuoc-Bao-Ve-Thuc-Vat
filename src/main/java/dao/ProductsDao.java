package dao;

import bean.Product;
import bean.Products;
import db.JDBIConnector;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductsDao implements IProductsDao{
    // lấy ra ds sp đc active.
    @Override
    public List<Products> findAll1(String name) {
        List<Products> products=JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT id,product_name,picture,price,id_category FROM product WHERE status=1 AND product_name LIKE ?")
                        .bind(0,"%"+name+"%")
                        .mapToBean(Products.class).collect(Collectors.toList()));
        return products;
    }

    @Override
    public List<Products> findByCategory(int idCate, String name) {
        List<Products> products = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT id, product_name, picture, price, id_category\n" +
                                "FROM product\n" +
                                "WHERE status = 1 AND id_category = ? AND product_name LIKE ?")
                        .bind(0, idCate)
                        .bind(1, "%" + name + "%")
                        .mapToBean(Products.class)
                        .list());
        return products;
    }
    // lấy ra số lượng của toàn bộ loại sản phẩm.
    public static int numOfProduct(String search){
        Integer integer = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT COUNT(*)  FROM product where product_name LIKE ?")
                        .bind(0,"%"+search+"%")
                        .mapTo(Integer.class)
                        .one());
        return integer != null ?integer :0;
    }
    // lấy ra số lượng toàn bộ loại sản phẩm theo doanh mục.
    public static int numOfProCate(int idCate,String search){
        Integer integer = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT COUNT(*)  FROM product where id_category=? AND product_name LIKE ?")
                        .bind(0,idCate)
                        .bind(1,"%"+search+"%")
                        .mapTo(Integer.class)
                        .one());
        return integer != null ?integer :0;
    }


    //=============================================dưới là phần của admin==========================================================
    public static List<Products>productList(String search) {
        List<Products> products = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT product.id,product.product_name,product.picture,product.price, product.id_category,product.quantity, product.status, product.specifications,product.des\n" +
                                "FROM product \n" +
                                "INNER JOIN category_product ON product.id_category=category_product.id\n" +
                                "WHERE product.product_name LIKE ? OR category_product.category_name LIKE ?")
                        .bind(0,"%"+search+"%")
                        .bind(1,"%"+search+"%")
                        .mapToBean(Products.class).collect(Collectors.toList()));
        return products;
    }
    public static List<Products> getTenPro(int index, String search) {
        List<Products> products = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT product.id, product.product_name, product.picture, product.price, product.id_category, product.quantity, product.status, product.des, product.specifications\n" +
                                "FROM product\n" +
                                "INNER JOIN category_product ON product.id_category = category_product.id\n" +
                                "WHERE product.product_name LIKE ? OR category_product.category_name LIKE ?\n" +
                                "ORDER BY product.id\n" +
                                "LIMIT 10 OFFSET ?")
                        .bind(0, "%" + search + "%")
                        .bind(1, "%" + search + "%")
                        .bind(2, (index - 1) * 10)
                        .mapToBean(Products.class)
                        .collect(Collectors.toList()));
        return products;
    }

    // Phương thức dưới lấy ra tên Category của 1 sp bất kỳ theo id sản phẩm.
    public static String CateOfProduct(int id){
        String cateName = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT c.category_name FROM product p " +
                                "INNER JOIN category_product c ON p.id_category = c.id " +
                                "WHERE p.id = ?")
                        .bind(0, id)
                        .mapTo(String.class)
                        .one()); // Sử dụng oneOrNull để tránh ngoại lệ khi không tìm thấy dữ liệu

        return cateName != null ? cateName : "";
    }
    public static void insertProduct(String name, String picture, int price, int category, int quantity, int status, String specifications, String desc) {
        try {
            JDBIConnector.getJdbi().useHandle(handle ->
                    handle.createUpdate("INSERT INTO product(product_name, picture, price, id_category, quantity, status, specifications, des) " +
                                    "VALUES(?,?,?,?,?,?,?,?)")
                            .bind(0, name)
                            .bind(1, picture)
                            .bind(2, price)
                            .bind(3, category)
                            .bind(4, quantity)
                            .bind(5, status)
                            .bind(6, specifications)
                            .bind(7, desc)
                            .execute());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteProduct(int proID){
        JDBIConnector.getJdbi().useHandle(handle ->
                handle.createUpdate("DELETE FROM product WHERE id = ?")
                        .bind(0,proID)
                        .execute());
    }
    public static Products getProductById(int proID){
        Optional<Products> products = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT product.id, product.product_name, product.picture, product.price, product.id_category, product.quantity, product.status, product.specifications, product.des\n" +
                                "FROM product\n" +
                                "WHERE product.id=?")
                        .bind(0, proID)
                        .mapToBean(Products.class).stream().findFirst());
        return products.isEmpty() ? null : products.get();
    }
    //UPDATE product SET product_name="dfsd",picture="fdsfs",price=5090,id_category=1,quantity=78,status=0,specifications="dfdsf",des="dfsdf" WHERE id=46
    public static void editProduct(String name,String picture,int price,int idCategory,int quantity,int status,String specifications,String proDesc,int id){
        JDBIConnector.getJdbi().useHandle(handle ->
                handle.createUpdate("UPDATE product SET product_name=?,picture=?,price=?,id_category=?,quantity=?,status=?,specifications=?,des=? WHERE id=?")
                        .bind(0,name)
                        .bind(1,picture)
                        .bind(2,price)
                        .bind(3,idCategory)
                        .bind(4,quantity)
                        .bind(5,status)
                        .bind(6,specifications)
                        .bind(7,proDesc)
                        .bind(8,id)
                        .execute()
        );
    }

    public static void main(String[] args) {
        ProductsDao.insertProduct("zxc", "img/product/product-2.jpg", 123, 1, 123,1,"432", "123123");
    }
}
