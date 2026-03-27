package bo;

import bean.Category;
import dao.CategoryDAO;

import java.util.ArrayList;
import java.util.List;

public class CategoryBO {

    CategoryDAO cd = new CategoryDAO();

    public List<Category> getListCategory() {
        return cd.getList();
    }
}
