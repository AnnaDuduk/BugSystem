package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DefectsModel {
    public ArrayList<DefectModel> getDefectsList() {
        try {
            ArrayList<DefectModel> result = new ArrayList<>();
            Database db = Database.getInstance();
            ResultSet rs = db.Query("SELECT * FROM Defects;");
            while(rs.next()) {
                result.add(new DefectModel(
                        rs.getInt("Id"),
                        rs.getString("Title"),
                        rs.getString("Description"), 
                        rs.getInt("Severity"), 
                        rs.getBoolean("Closed"),
                        rs.getInt("Category_Id")
                        ));
            }
            return result;
        } catch (Exception ex) {
            Logger.getLogger(DefectsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void setDefect(DefectModel defect) {
        Database db = Database.getInstance();
        db.Update(String.format(
                "INSERT INTO DEFECTS (title, description, severity, closed, category_id) VALUES('%s', '%s', %d, %b, %d)", 
                defect.getTitle(), 
                defect.getDescription(), 
                defect.getSeverity(), 
                defect.getClosed(),
                defect.getCategoryId()
                ));
    }

    public void deleteDefect(int id) {
        Database db = Database.getInstance();
        db.Update(String.format("DELETE FROM DEFECTS WHERE ID = %d", id));
    }

    public void closeDefect(int id) {
        Database db = Database.getInstance();
        db.Update(String.format("UPDATE DEFECTS SET CLOSED=TRUE WHERE ID = %d", id));
    }

    public void reopenDefect(int id) {
        Database db = Database.getInstance();
        db.Update(String.format("UPDATE DEFECTS SET CLOSED=FALSE WHERE ID = %d", id));
    }
    
    public void raiseSeverity(int defectId) {
        Database db = Database.getInstance();
        db.Update(String.format("UPDATE DEFECTS SET SEVERITY=SEVERITY+1 WHERE ID = %d", defectId));
    }

    public void lowerSeverity(int defectId) {
        Database db = Database.getInstance();
        db.Update(String.format("UPDATE DEFECTS SET SEVERITY=SEVERITY-1 WHERE ID = %d", defectId));
    }
}
