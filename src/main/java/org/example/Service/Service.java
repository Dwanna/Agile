package org.example.Service;


import org.example.Dao.Database;
import org.example.Entity.Employee;

public interface Service {

    Boolean login(String username, String password);
    Boolean logout(String username);
    Boolean createEmployee(Employee employee, Database db);
    Boolean searchEmployee(String BadgeNo,Database db);
    Boolean updateEmployee(Employee employee,Database db);
    Boolean deleteEmployee(String BadgeNo,Database db);
}
