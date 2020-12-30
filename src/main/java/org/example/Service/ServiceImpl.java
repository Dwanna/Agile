package org.example.Service;


import org.example.Entity.Employee;
import org.example.Exception.ExceptionHandler;

public class ServiceImpl implements Service {
    @Override
    public Boolean login(String username, String password) {
        boolean res=false;
        if(!username.equals("admin")){
            throw new ExceptionHandler("Invalid Username");
        }
        else if(!password.equals("password")){
            throw new ExceptionHandler("Invalid Password");
        }
        else if(username.equals("admin") && password.equals("password")){
            res=true;
        }
        return res;
    }

    @Override
    public Boolean logout(String username) {
        return null;
    }
    public String test()
    {
        return "this";
    }

    @Override
    public Boolean createEmployee(Employee employee) {
        return null;
    }

    @Override
    public Boolean searchEmployee(String BadgeNo) {
        return null;
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public Boolean deleteEmployee(String BadgeNo) {
        return null;
    }
}
