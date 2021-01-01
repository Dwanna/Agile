package org.example;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.example.Dao.Database;
import org.example.Entity.Employee;
import org.example.Exception.ExceptionHandler;
import org.example.Service.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * Unit test for simple App.
 */
//@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {
    ServiceImpl service = new ServiceImpl();


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }


    @Test
    public void login01() {

//        when(service.login("daniel", "pass")).thenThrow(ExceptionHandler.class);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.login("sdd", "pass");
                }
        );
        assertEquals("Invalid Username", exception.getMessage());
    }

    @Test
    public void login02() {

        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.login("admin", "passs");
                }
        );
        assertEquals("Invalid Password", exception.getMessage());


    }

    @Test
    public void login03() {

        assertEquals(true, service.login("admin", "password"));
    }


    @Test
    public void logout01() {
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.logout("adminW");
                }
        );
        assertEquals("Invalid Username", exception.getMessage());

    }

    @Test
    public void logout02() {
        assertEquals(true, service.logout("admin"));
    }

    @Test
    public void createEmployee01() throws Exception {
        Employee emp = new Employee("a", "daniel", "A001", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);

        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("First name is invalid", exception.getMessage());
    }

    @Test
    public void createEmployee02() {
        Employee emp = new Employee("aaaaaaaaaaaaaaaa", "daniel", "A001", 24, "0871231231", "oje@gmail.com");

        Database db = mock(Database.class);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("First name is invalid", exception.getMessage());

    }

    @Test
    public void createEmployee03() {

        Employee emp = new Employee("aaaaaa12", "daniel", "A001", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("First name is invalid", exception.getMessage());
    }

    @Test
    public void createEmployee04() {

        Employee emp = new Employee("Ayo", "d", "A001", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Last name is invalid", exception.getMessage());

    }

    @Test
    public void createEmployee05() {

        Employee emp = new Employee("Ayo", "dddddddddddd", "A001", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Last name is invalid", exception.getMessage());

    }

    @Test
    public void createEmployee06() {

        Employee emp = new Employee("Ayo", "ddd12", "A001", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Last name is invalid", exception.getMessage());
    }

    @Test
    public void createEmployee07() {
        Employee emp = new Employee("Ayo", "Daniel", "A0", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Badge Number is invalid", exception.getMessage());

    }

    @Test
    public void createEmployee08() {
        Employee emp = new Employee("Ayo", "Daniel", "A000002", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);

        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Badge Number is invalid", exception.getMessage());

    }

    @Test
    public void createEmployee09() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 16, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);

        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Age is invalid", exception.getMessage());


    }

    @Test
    public void createEmployee10() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 75, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);

        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Age is invalid", exception.getMessage());
    }

    @Test
    public void createEmployee11() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231111", "oje@gmail.com");
        Database db = mock(Database.class);

        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Phone number is invalid", exception.getMessage());
    }

    @Test
    public void createEmployee12() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "08712312", "oje@gmail.com");
        Database db = mock(Database.class);

        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Phone number is invalid", exception.getMessage());
    }

    @Test
    public void createEmployee13() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "087123121e1", "oje@gmail.com");

        Database db = mock(Database.class);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Phone number is invalid", exception.getMessage());

    }

    @Test
    public void createEmployee14() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231", "ojegmail.com");

        Database db = mock(Database.class);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Email is invalid", exception.getMessage());

    }

    @Test
    public void createEmployee15() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231", "ojegmail.com");

        Database db = mock(Database.class);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Email is invalid", exception.getMessage());

    }

    @Test
    public void createEmployee16() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231", "oje@gmailcom");

        Database db = mock(Database.class);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
        assertEquals("Email is invalid", exception.getMessage());

    }
    @Test
    public void createEmployee17() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231", "oje@gmailcom");

        Database db = mock(Database.class);

        //when(db.findEmployeeByBadge("A002")).thenReturn("A value");
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.createEmployee(emp, db);
                }
        );
//        assertEquals("Badge Number already exist", exception.getMessage());
            assertEquals("Badge Number already exist",exception.getMessage());
    }

    @Test
    public void createEmployee18() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.createEmployee(emp)).thenReturn(true);

        assertEquals(true, service.createEmployee(emp, db));

    }



    @Test
    public void updateEmployee01() throws Exception {
        Employee emp = new Employee("a", "daniel", "A001", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);

        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("First name is invalid", exception.getMessage());
    }

    @Test
    public void updateEmployee02() {
        Employee emp = new Employee("aaaaaaaaaaaaaaaa", "daniel", "A001", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("First name is invalid", exception.getMessage());

    }

    @Test
    public void updateEmployee03() {

        Employee emp = new Employee("aaaaaa12", "daniel", "A001", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("First name is invalid", exception.getMessage());
    }

    @Test
    public void updateEmployee04() {

        Employee emp = new Employee("Ayo", "d", "A001", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("Last name is invalid", exception.getMessage());

    }

    @Test
    public void updateEmployee05() {

        Employee emp = new Employee("Ayo", "dddddddddddd", "A001", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("Last name is invalid", exception.getMessage());

    }

    @Test
    public void updateEmployee06() {

        Employee emp = new Employee("Ayo", "ddd12", "A001", 24, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("Last name is invalid", exception.getMessage());
    }



    @Test
    public void updateEmployee07() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 16, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("Age is invalid", exception.getMessage());


    }

    @Test
    public void updateEmployee08() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 75, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("Age is invalid", exception.getMessage());
    }

    @Test
    public void updateEmployee09() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231111", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("Phone number is invalid", exception.getMessage());
    }

    @Test
    public void updateEmployee10() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "08712312", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("Phone number is invalid", exception.getMessage());
    }

    @Test
    public void updateEmployee11() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "087123121e1", "oje@gmail.com");

        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("Phone number is invalid", exception.getMessage());

    }

    @Test
    public void updateEmployee12() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231", "ojegmail.com");

        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("Email is invalid", exception.getMessage());

    }

    @Test
    public void updateEmployee13() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231", "ojegmail.com");

        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("Email is invalid", exception.getMessage());

    }

    @Test
    public void updateEmployee14() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231", "oje@gmailcom");

        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
        assertEquals("Email is invalid", exception.getMessage());

    }
    @Test
    public void updateEmployee15() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231", "oje@gmailcom");

        Database db = mock(Database.class);

        //when(db.findEmployeeByBadge("A002")).thenReturn("A value");
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(false);
        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.updateEmployee(emp, db);
                }
        );
//        assertEquals("Badge Number already exist", exception.getMessage());
        assertEquals("Badge Number doesnt exist",exception.getMessage());
    }

    @Test
    public void updateEmployee16() {
        Employee emp = new Employee("Ayo", "Daniel", "A002", 19, "0871231231", "oje@gmail.com");
        Database db = mock(Database.class);
        when(db.badgeNumberExist(emp.getBadgeNo())).thenReturn(true);

        assertEquals(true, service.updateEmployee(emp, db));

    }








}
