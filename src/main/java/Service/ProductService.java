package Service;

import bean.Product;
import bean.Products;
import dao.IProductDAO;
import dao.ProductDAO;

import java.util.List;

public class ProductService implements IProductService{
    private IProductDAO productDAO = new ProductDAO();
    @Override
    public List<Products> findAll1() {
        return productDAO.findAll1();
    }

    @Override
    public List<Product> findAll2() {
        return productDAO.findAll2();
    }

    @Override
    public Products findById(int id) {
        return productDAO.findById(id).stream().findFirst().get();
    }

}
