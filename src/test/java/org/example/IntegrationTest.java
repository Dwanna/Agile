package org.example;

import org.example.Dao.Database;
import org.example.Entity.Employee;
import org.example.Exception.ExceptionHandler;
import org.example.Service.ServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
public class IntegrationTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
     ServiceImpl service= new ServiceImpl();

    @Test
    public void integrationTest(){

        Employee employee = new Employee("Ayodeji","Ojeaburu","A001",23,"0873223233","oj@gmail.com");

        assertEquals(true,service.login("admin","password"));
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.login("sdd", "pass");
                }
        );
        assertEquals("Invalid Username",exception.getMessage());


        assertTrue(service.logout("admin"));

        assertEquals(true,service.login("admin","password"));
        Throwable exception1 = assertThrows(
                ExceptionHandler.class, () -> {
                    service.logout("sdd");
                }
        );
        assertEquals("Invalid Username",exception1.getMessage());

        Database db= mock(Database.class);

        when(db.createEmployee(employee)).thenReturn(true);

        assertEquals(true, service.createEmployee(employee, db));

        when(db.badgeNumberExist(employee.getBadgeNo())).thenReturn(true);

        assertEquals(true, service.updateEmployee(employee, db));


        when(db.badgeNumberExist("A002")).thenReturn(true);
        when(db.findEmployeeByBadge("A002")).thenReturn(employee);
        String res="Employee FirstName: "+employee.getFirstName()+"\n Employee LastName: "
                +employee.getLastName()+"\n Employee Age: "+employee.getAge()+"\n Employee BadgeNo: "
                +employee.getBadgeNo()+"\n Employee Email: "+employee.getEmail()+"\n Employee Phone Number: "
                +employee.getPhoneNumber()+"\n";


        assertEquals(res,service.searchEmployee("A002",db) );








    }
}
