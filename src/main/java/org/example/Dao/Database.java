package org.example.Dao;

import org.example.Entity.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

    private static  Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void initDBConnection() {/// Connection with mySQL database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Agile";

            con = DriverManager.getConnection(url, "root", "Danieldd11");

            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Dao.Database connection failed");
        }
    }
//    public static void main(String []args) {
//    	initDBConnection();
//    	System.out.println(badgeNumberExist("A001"));
//    }





    public boolean createEmployee(Employee employee) {



        String cmd = "INSERT INTO EmployeeTable VALUES("+null+",'" + employee.getFirstName() + "','" + employee.getLastName() + "'," +employee.getAge()
                + ",'" + employee.getBadgeNo() + "','"+employee.getEmail()+"','"+employee.getPhoneNumber()+"');";
        try {
            stmt.executeUpdate(cmd);

            return true;
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
        return false;
    }
    public boolean updateEmployee(Employee employee) {



        String cmd = "update EmployeeTable set firstname='"+employee.getFirstName()+"',lastname='"+employee.getLastName()+"',email='"+employee.getEmail()+"',age='"+employee.getAge()+"',phoneno='"+employee.getPhoneNumber()+"' where badgeno='"+employee.getBadgeNo()+"';";
        try {
            stmt.executeUpdate(cmd);

            return true;
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
        return false;
    }


    public  Employee findEmployeeByBadge(String badge){
        Employee employee= new Employee();
        String res="";
        String firstname = "",lastname="",badgeno="",phonenumber="",email="";
        int age=0;

        String cmd = "select * from EmployeeTable where badgeno='"+badge+"'";
        try {
            rs = stmt.executeQuery(cmd);

            while (rs.next()) {

                firstname = rs.getString(2);
                lastname = rs.getString(3);
                age = rs.getInt(4);
                badgeno = rs.getString(5);
                email=rs.getString(6);
                phonenumber=rs.getString(7);

            }
            employee.setFirstName(firstname);
            employee.setLastName(lastname);
            employee.setPhoneNumber(phonenumber);
            employee.setEmail(email);
            employee.setBadgeNo(badgeno);
            employee.setAge(age);
            //res="Employee FirstName: "+firstname+"\n Employee LastName: "+lastname+"\n Employee Age: "+age+"\n Employee BadgeNo: "+badgeno+"\n Employee Email: "+email+"\n Employee Phone Number: "+phonenumber+"\n";
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }



        return employee;
    }

    public  boolean badgeNumberExist(String badge){
        if(findEmployeeByBadge(badge).getFirstName().trim().matches("")){
            //System.out.println(false);
            return false;
        }
        else{
            //System.out.println(true);
            return true;
        }
    }
}
