package org.example.Service;


import org.example.Entity.Employee;

public interface Service {

    Boolean login(String username, String password);
    Boolean logout(String username);
    Boolean createEmployee(Employee employee);
    Boolean searchEmployee(String BadgeNo);
    Boolean updateEmployee(Employee employee);
    Boolean deleteEmployee(String BadgeNo);
}
