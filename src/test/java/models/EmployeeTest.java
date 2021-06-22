package models;
import org.junit.Test;
import static org.junit.Assert.*;
public class EmployeeTest {
    @Test
    public void EmployeesInstantiatesCorrectly_true() throws Exception {
        Employee employees = setupEmployees();
        assertTrue(employees instanceof Employee);
    }
    @Test
    public void EmployeesInstantiatesCorrectlyWith_Values()throws Exception{
        Employee employees= setupEmployees();
        assertEquals("sam",employees.getName());
        assertEquals("H.o D",employees.getTitle());

        assertEquals("head of dept",employees.getId());

    }
    @Test
    public void setId()throws Exception{
        Employee employees = setupEmployees();
        employees.setId(3);
        assertNotEquals(2,employees.getId());
    }
    public Employee setupEmployees(){
        return new Employee("sam", "H.o.D", "2","222-Nakuru");
    }
}