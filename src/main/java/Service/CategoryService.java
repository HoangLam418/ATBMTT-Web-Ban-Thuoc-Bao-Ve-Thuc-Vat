package Service;

import bean.Category;
import dao.CategoryDAO;

import java.util.List;

public class CategoryService {
    private static CategoryService instance;
    public static CategoryService getInstance(){
        if(instance ==null ) instance=new CategoryService();
        return instance;
    }
    public List<Category> listCategory(String name,int index){
        return CategoryDAO.listCategory(name, index);
    }
    public void insertCategory(String nameCate){
        CategoryDAO.insertCategory(nameCate);
    }
    public void  deleteCategory(int idCate){
        CategoryDAO.deleteCategory(idCate);
    }
    public void updateCategory(String categoryName,int idCategory){
        CategoryDAO.updateCategory(categoryName, idCategory);
    }

    public static void main(String[] args) {
        System.out.println(CategoryService.getInstance().listCategory("",0));
    }
}
