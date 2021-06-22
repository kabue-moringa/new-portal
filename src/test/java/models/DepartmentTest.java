package models;
import org.junit.Test;

import static org.junit.Assert.*;
public class DepartmentTest {
    @Test
    public void DepartmentInstantiatesCorrectly() throws Exception{
        Department department =setupDepartment();
        assertTrue(department instanceof Department);
    }
    @Test
    public void Department_instantiatesWithCorrectValues() throws Exception{
        Department department = setupDepartment();
        assertEquals("offices", department.getName());
        assertEquals("working spaces",department.getDescription());
        assertEquals(2,department.getEmployees());
    }
    @Test
    public void setId() throws Exception{
        Department department = setupDepartment();
        department.setId(3);
        assertNotEquals(2,department.getId());
    }
    public Department setupDepartment(){
        return new Department("offices", "working spaces", 2);
    }
}

