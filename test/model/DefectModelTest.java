package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DefectModelTest {
    private DefectModel instance;

    
    public DefectModelTest() {
    }

    @Before
    public void setUpTest() throws Exception {
        instance = new DefectModel(3, "Тестовый дефект", "Тестовое описание", 2, true, 4);
    }


    @Test
    public void testGetId() {
        int expResult = 3;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTitle() {
        String expResult = "Тестовый дефект";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDescription() {
        String expResult = "Тестовое описание";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSeverity() {
        int expResult = 2;
        int result = instance.getSeverity();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetClosed() {
        boolean expResult = true;
        boolean result = instance.getClosed();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCategoryId() {
        int expResult = 4;
        int result = instance.getCategoryId();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTitle() throws Exception {
        String value = "Новый заголовок";
        instance.setTitle(value);
        String result = instance.getTitle();
        assertEquals(value, result);
    }

    @Test
    public void testSetDescription() throws Exception {
        String value = "Новое описание";
        instance.setDescription(value);
        String result = instance.getDescription();
        assertEquals(value, result);
    }

    @Test
    public void testSetSeverity() throws Exception {
        int value = 5;
        instance.setSeverity(value);
        int result = instance.getSeverity();
        assertEquals(value, result);
    }

    @Test
    public void testSetCategoryId() {
        int value = 1;
        instance.setCategoryId(value);
        int result = instance.getCategoryId();
        assertEquals(value, result);
    }

    @Test
    public void testSetClosed() {
        boolean value = false;
        instance.setClosed(value);
        boolean result = instance.getClosed();
        assertEquals(value, result);
    }
}
