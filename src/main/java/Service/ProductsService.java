package Service;

import bean.Products;
import dao.*;

import java.util.List;

public class ProductsService {
    private static ProductsService instance;

    public static ProductsService getInstance(){
        if(instance ==null ) instance = new ProductsService();
        return instance;
    }
    private IProductsDao productDAO = new ProductsDao();
    public List<Products> findAll1(String name){
        return productDAO.findAll1(name);
    }
    public List<Products>findByCategory(int idCate,String name){
        return productDAO.findByCategory(idCate,name);
    }
    public int numOfProduct(String search){
        return ProductsDao.numOfProduct(search);
    }
    public int numOfProCate(int idCate,String search){
        return ProductsDao.numOfProCate(idCate,search);
    }

    //=======================================Dưới là của admin=============================================
    public List<Products> productList(String search) {
        return ProductsDao.productList(search);
    }
    public List<Products>getTenPro(int index,String search){return ProductsDao.getTenPro(index,search);}
    public void insertProduct(String name, String picture, int price, int category, int quantity, int status, String specifications, String desc){
        ProductsDao.insertProduct(name, picture, price, category, quantity, status, specifications, desc);
    }
    public void deleteProduct(int proID){
        ProductsDao.deleteProduct(proID);
    }
    public Products getProductById(int proID){return ProductsDao.getProductById(proID);}
    public void editProduct(String name,String picture,int price,int idCategory,int quantity,int status,String specifications,String proDesc,int id){
        ProductsDao.editProduct(name, picture, price, idCategory, quantity, status, specifications, proDesc, id);
    }
    public static void main(String[] args) {
        System.out.println(ProductsService.getInstance().getProductById(1));
    }


}
