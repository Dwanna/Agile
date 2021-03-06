package org.example.Service;


import org.example.Dao.Database;
import org.example.Entity.Employee;
import org.example.Exception.ExceptionHandler;

public class ServiceImpl implements Service {

    @Override
    public Boolean login(String username, String password) {
        boolean res = false;
        if (!username.equals("admin")) {
            throw new ExceptionHandler("Invalid Username");
        } else if (!password.equals("password")) {
            throw new ExceptionHandler("Invalid Password");
        } else if (username.equals("admin") && password.equals("password")) {
            res = true;

        }
        return res;
    }

    @Override
    public Boolean logout(String username) {
        boolean res = false;
        if (!username.equals("admin")) {
            throw new ExceptionHandler("Invalid Username");
        } else {
            res = true;
            return res;
        }
    }


    @Override
    public Boolean createEmployee(Employee employee,Database db) {
        boolean res = false;
        if(db.badgeNumberExist(employee.getBadgeNo())){
            throw new ExceptionHandler("Badge Number already exist");
        }
        else if (employee.getFirstName().length() < 2 || employee.getFirstName().length() > 10 || employee.getFirstName().matches(".*\\d+.*")) {
            throw new ExceptionHandler("First name is invalid");
        } else if (employee.getLastName().length() < 2 || employee.getLastName().length() > 10 || employee.getLastName().matches(".*\\d+.*")) {
            throw new ExceptionHandler("Last name is invalid");
        } else if (employee.getBadgeNo().length() < 3 || employee.getBadgeNo().length() > 5) {
            throw new ExceptionHandler("Badge Number is invalid");
        } else if (employee.getAge() < 17 || employee.getAge() > 70) {
            throw new ExceptionHandler("Age is invalid");
        } else if (employee.getPhoneNumber().length() < 9 || employee.getPhoneNumber().length() > 11 || !employee.getPhoneNumber().matches("[0-9]+")) {
            throw new ExceptionHandler("Phone number is invalid");
        } else if (!employee.getEmail().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            throw new ExceptionHandler("Email is invalid");
        }
        else{
            res=true;
            db.createEmployee(employee);


        }


        return res;
    }

    @Override
    public String searchEmployee(String BadgeNo,Database db) {
        String res="";


        if(!db.badgeNumberExist(BadgeNo)){
            //System.out.println(false);
            throw new ExceptionHandler("Badge Number doesnt exist");
        }
        else{
            Employee employee= db.findEmployeeByBadge(BadgeNo);
            res="Employee FirstName: "+employee.getFirstName()+"\n Employee LastName: "+employee.getLastName()+"\n Employee Age: "+employee.getAge()+"\n Employee BadgeNo: "+employee.getBadgeNo()+"\n Employee Email: "+employee.getEmail()+"\n Employee Phone Number: "+employee.getPhoneNumber()+"\n";
            //res=db.findEmployeeByBadge(BadgeNo);
        }



        return res;
    }

    @Override
    public Boolean updateEmployee(Employee employee,Database db) {

        boolean res = false;
        if(!db.badgeNumberExist(employee.getBadgeNo())){
            throw new ExceptionHandler("Badge Number doesnt exist");
        }
        else if (employee.getFirstName().length() < 2 || employee.getFirstName().length() > 10 || employee.getFirstName().matches(".*\\d+.*")) {
            throw new ExceptionHandler("First name is invalid");
        } else if (employee.getLastName().length() < 2 || employee.getLastName().length() > 10 || employee.getLastName().matches(".*\\d+.*")) {
            throw new ExceptionHandler("Last name is invalid");
        } else if (employee.getAge() < 17 || employee.getAge() > 70) {
            throw new ExceptionHandler("Age is invalid");
        } else if (employee.getPhoneNumber().length() < 9 || employee.getPhoneNumber().length() > 11 || !employee.getPhoneNumber().matches("[0-9]+")) {
            throw new ExceptionHandler("Phone number is invalid");
        } else if (!employee.getEmail().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            throw new ExceptionHandler("Email is invalid");
        }
        else{
            res=true;
            db.updateEmployee(employee);


        }
        return res;
    }

    @Override
    public Boolean deleteEmployee(String BadgeNo,Database db) {
        boolean res=false;


        if(!db.badgeNumberExist(BadgeNo)){
            //System.out.println(false);
            throw new ExceptionHandler("Badge Number doesnt exist");
        }
        else{
            res=true;
            db.deleteEmployee(BadgeNo);

        }



        return res;
    }
}
