package model;

import java.io.Serializable;

public final class CategoryModel implements Serializable {
    private int id;
    private String name;
    
    public CategoryModel() {
    }
    
    public CategoryModel(int id, String name) throws Exception {
        this(name);
        this.id = id;
    }
    
    public CategoryModel(String name) throws Exception {
        setName(name);
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String value) throws Exception {
        if (value.isEmpty()) {
            throw new Exception("Название не может быть пустым.");
        } else {
            name = value;
        }
    }
}
