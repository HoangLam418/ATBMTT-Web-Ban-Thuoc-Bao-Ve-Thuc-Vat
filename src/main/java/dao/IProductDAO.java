package dao;

import bean.Product;
import bean.Products;

import java.util.List;

public interface IProductDAO {
    List<Products> findAll1();
    List<Product> findAll2();

    List<Products> findNewPro1();

    List<Products> findNewPro2();

    List<Products> findDiscountPro1();

    List<Products> findDiscountPro2();

    List<Products> findById(int id);

    List<Products> findByPriceMax(String id);

    List<Products> findByPriceMin(String id);
}
