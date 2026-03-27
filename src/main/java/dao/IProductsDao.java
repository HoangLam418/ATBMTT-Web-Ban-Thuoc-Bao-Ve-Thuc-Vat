package dao;

import bean.Products;

import java.util.List;

public interface IProductsDao {
    List<Products> findAll1(String name);
    List<Products> findByCategory(int idCate,String name);
}
