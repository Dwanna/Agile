package org.example;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.Exception.ExceptionHandler;
import org.example.Service.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;



/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
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
                    service.login("sdd","pass");
                }
        );
        assertEquals("Invalid Username",exception.getMessage());
    }
    @Test
    public void login02() {

        Throwable exception = assertThrows(
                ExceptionHandler.class, () -> {
                    service.login("admin","passs");
                }
        );
        assertEquals("Invalid Password",exception.getMessage());


    }


}
