package model;

import java.io.Serializable;

public final class DefectModel implements Serializable {
    private int id;
    private String title;
    private String description;
    private int severity;
    private boolean closed;
    private int categoryId;
    
    public DefectModel() { 
    }
    
    public DefectModel(int id, String title, String description, int severity, boolean closed, int categoryId) throws Exception {
        this(title, description, severity, closed, categoryId);
        this.id = id;
    }

    
    public DefectModel(String title, String description, int severity, boolean closed, int categoryId) throws Exception {
        setTitle(title);
        setDescription(description);
        setSeverity(severity);
        setClosed(closed);
        setCategoryId(categoryId);
    }
 
    public int getId()
    {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }

    public int getSeverity() {
        return severity;
    }

    public boolean getClosed() {
        return closed;
    }
    
    public int getCategoryId() {
        return categoryId;
    }
    
    public void setTitle(String value) throws Exception {
        if (value.isEmpty()) {
            throw new Exception("Заголовок не может быть пустым.");
        } else {
            title = value;
        }
    }
    
    public void setDescription(String value) throws Exception {
        if (value.isEmpty()) {
            throw new Exception("Описание не может быть пустым.");
        } else {
            description = value;
        }
    }
    
    public void setSeverity(int value) throws Exception {
        if (value >= 1 && value <= 5) {
            severity = value;
        } else {
            throw new Exception("Важность должна быть в диапазоне 1-5.");
        }
    }
    
    public void setCategoryId(int value) {
        categoryId = value;;
    }
    
    public void setClosed(boolean value) {
        closed = value;
    }
}
