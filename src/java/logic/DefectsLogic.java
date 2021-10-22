package logic;

import java.util.ArrayList;
import model.CategoryModel;
import model.DefectModel;
import model.DefectsModel;

public class DefectsLogic {
    private static DefectsModel model = new DefectsModel();
    
    public static ArrayList<DefectModel> getDefectsList() {
        return model.getDefectsList();
    }
    
    public static void newDefect(String title, String description, int severity, boolean closed, int categoryId) throws Exception {
        model.setDefect(new DefectModel(title, description, severity, closed, categoryId));
    }

    public static void deleteDefect(int id) {
        model.deleteDefect(id);
    }

    public static void closeDefect(int id) {
        model.closeDefect(id);
    }
    
    public static void reopenDefect(int id) {
        model.reopenDefect(id);
    }

    public static void raiseSeverity(int defectId) {
        model.raiseSeverity(defectId);
    }

    public static void lowerSeverity(int defectId) {
        model.lowerSeverity(defectId);
    }
    
    public static String getCategoryName(DefectModel defect) {
        return getCategoryName(defect.getCategoryId());
    }
    
    private static String getCategoryName(int categoryId) {
        CategoryModel category = CategoriesLogic.getCategoryById(categoryId);
        String categoryName;
        if (category==null) {
            categoryName = "[Удалена]";
        } else {
            categoryName = category.getName();
        }
        return categoryName;
    }    

    public static DefectModel getDefectById(int id)
    {
        ArrayList<DefectModel> list = model.getDefectsList();
        for (DefectModel defect : list) 
        {
            if (defect.getId() == id) {
                return defect;
            }
        }
        return null;
    }
}
