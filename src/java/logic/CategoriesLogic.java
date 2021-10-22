package logic;

import java.util.ArrayList;
import model.CategoriesModel;
import model.CategoryModel;

public class CategoriesLogic {
    private static CategoriesModel model = new CategoriesModel();
    
    public static ArrayList<CategoryModel> getCategoriesList() {
        return model.getCategoriesList();
    }

    public static void newCategory(String name) throws Exception {
        model.setCategory(new CategoryModel(name));
    }

    public static void deleteCategory(int id) {
        model.deleteCategory(id);
    }

    public static CategoryModel getCategoryById(int id) {
        ArrayList<CategoryModel> list = model.getCategoriesList();
        for (CategoryModel category : list) 
        {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
