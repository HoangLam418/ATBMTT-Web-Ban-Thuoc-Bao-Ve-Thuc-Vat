package dao;

import bean.Category;
import bean.Product;
import db.DBContext;
import db.JDBIConnector;
import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryDAO {
    public List<Category> getList(){
        Jdbi jdbi = JDBIConnector.getJdbi();
        List<Category> cateList = jdbi.withHandle(handle -> {
            String sql = "SELECT id, category_name FROM category_product"; // Modify the SQL query
            return handle.createQuery(sql).mapToBean(Category.class).list();
        });
        return cateList;
    }
    // đây là danh sách category có thể tìm theo tên và chia số trang.
    public static List<Category> listCategory(String name,int index){
        List<Category> listCate = JDBIConnector.getJdbi().withHandle(handle ->
                handle.createQuery("SELECT id, category_name\n" +
                                "FROM category_product\n" +
                                "WHERE category_name LIKE ?" +
                                "ORDER BY id LIMIT 5 OFFSET ?")
                        .bind(0, "%"+name+"%")
                        .bind(1, index)
                        .mapToBean(Category.class)
                        .collect(Collectors.toList()));
        return  listCate;
    }
    // thêm doanh mục
    public static void insertCategory(String nameCate){
        JDBIConnector.getJdbi().useHandle(handle ->
                handle.createUpdate("INSERT INTO category_product(category_name) VALUES (?)")
                        .bind(0, nameCate)
                        .execute()
        );
    }
    // xóa danh mục
    public static void deleteCategory(int idCate){
        JDBIConnector.getJdbi().useHandle(handle ->
                handle.createUpdate("DELETE FROM category_product WHERE id=?")
                        .bind(0,idCate)
                        .execute());
    }
    public static void updateCategory(String categoryName,int idCategory){
        JDBIConnector.getJdbi().useHandle(handle ->
                handle.createUpdate("UPDATE category_product SET  \n" +
                        "category_name=? WHERE id=?")
                        .bind(0,categoryName)
                        .bind(1,idCategory)
                        .execute());
    }


    public static void main(String[] args) {
//        CategoryDAO dao = new CategoryDAO();
//        List<Category> list = dao.getList();
//        for(Category i : list){
//            System.out.println(i.toString());
//        }
//        System.out.println(CategoryDAO.listCategory("ô",0));
        CategoryDAO.updateCategory("Phân bón",3);
    }

}
