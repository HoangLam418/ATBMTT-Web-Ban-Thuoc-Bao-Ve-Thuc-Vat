package Service;

import bean.Product;
import bean.Products;

import java.util.List;

public interface IProductService {
    List<Products> findAll1();
    List<Product> findAll2();
    Products findById(int id);
}
