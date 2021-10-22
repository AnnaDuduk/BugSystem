package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriesModel {
    public ArrayList<CategoryModel> getCategoriesList() {
        try {
            ArrayList<CategoryModel> result = new ArrayList<>();
            Database db = Database.getInstance();
            ResultSet rs = db.Query("SELECT * FROM Categories;");
            while(rs.next()) {
                result.add(new CategoryModel(
                        rs.getInt("Id"),
                        rs.getString("Name")
                        ));
            }
            return result;
        } catch (Exception ex) {
            Logger.getLogger(CategoriesModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void setCategory(CategoryModel category) {
        Database db = Database.getInstance();
        db.Update(String.format(
                "INSERT INTO Categories (name) VALUES('%s')", 
                category.getName()
                ));
    }

    public void deleteCategory(int id) {
        Database db = Database.getInstance();
        db.Update(String.format("DELETE FROM Categories WHERE ID = %d", id));
    }   
}
