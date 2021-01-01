package org.example.Main;

import org.example.Dao.Database;
import org.example.Entity.Employee;
import org.example.Exception.ExceptionHandler;
import org.example.Service.ServiceImpl;

import java.util.Scanner;


public class MainClass {
    static Scanner sc = new Scanner(System.in);
    static ServiceImpl service = new ServiceImpl();
    static Database db = new Database();
    static int count = 0;

    public static void main(String args[]) {
        db.initDBConnection();
        System.out.println("Select an Option");
        System.out.println("Press 1.Login for manager");
        System.out.println("Press 2.Exit");

        int choice = sc.nextInt();
        if (choice == 1) {
            managerLogin();
        } else if (choice == 2) {
            System.out.println("Application terminated");
            System.exit(0);
        } else {
            System.out.println("Please select 1 to go into manager login section");
            main(null);
        }

    }

    public static void managerLogin() {
        System.out.println("Welcome to Manager page \n -------------");

        // System.out.println(service.test());
        System.out.println("Enter your username:");
        String username = sc.next();


        System.out.println("Enter your password:");
        String password = sc.next();
        try {
            if (service.login(username, password)) {
                System.out.println("You have logged in");
                managerScreen();
            } else {
                managerLogin();
            }
        } catch (ExceptionHandler e) {
            System.out.println("Error detected:---->" + e.getMessage());
            managerLogin();
        }

    }

    public static void managerScreen() {
        System.out.println("Please select an option \n -----------------");
        System.out.println("Press 1.Add new employee \n -----------------");
        System.out.println("Press 2.Update existing employee \n -----------------");
        System.out.println("Press 3.Search for an employee \n -----------------");
        System.out.println("Press 4.Delete an employee \n -----------------");
        System.out.println("Press 5.Log out \n -----------------");

        int choice = sc.nextInt();
        if (choice == 1) {
            addEmployee();
        } else if (choice == 2) {
            updateEmployee();
        } else if (choice == 3) {
            searchEmployee();
        } else if (choice == 4) {
            deleteEmployee();
        } else if (choice == 5) {
            logOut();
        } else {
            System.out.println("-----------------------");
            System.out.println("Please select one of the option above \n -------------------");
            managerScreen();
        }

//		System.out.println("-------------------------");


    }

    public static void addEmployee() {
        System.out.println("Enter employee details \n --------------");

        System.out.println("Enter employee's first name \n -------------");
        String firstName = sc.next();

        System.out.println("Enter employee's last name \n ---------------");
        String lastName = sc.next();

        System.out.println("Enter employee's Age \n -------------------");
        int age = sc.nextInt();

        System.out.println("Enter employee's email address \n ------------------");
        String email = sc.next();

        System.out.println("Enter employee's phone number \n -------------------");
        String phoneNumber = sc.next();

        System.out.println("Enter employee's badge number \n -----------------");
        String badgeNumber = sc.next();

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setEmail(email);
        employee.setBadgeNo(badgeNumber);
        employee.setPhoneNumber(phoneNumber);

        try {
            if (service.createEmployee(employee, db)) {
                System.out.println("------- \n Employee has been created \n ------");
                managerScreen();

            }
        } catch (ExceptionHandler e) {
            System.out.println("|---------------|");
            System.out.println(e.getMessage());
            managerScreen();
        }


    }

    public static void updateEmployee() {
        System.out.println("To Update employee by their badge number \n ---------");
        System.out.println("Please enter employee's badge number to update employee's details\n -----------");
        String badgeNumber = sc.next();

        System.out.println("Enter employee's first name \n -------------");
        String firstName = sc.next();

        System.out.println("Enter employee's last name \n ---------------");
        String lastName = sc.next();

        System.out.println("Enter employee's Age \n -------------------");
        int age = sc.nextInt();

        System.out.println("Enter employee's email address \n ------------------");
        String email = sc.next();

        System.out.println("Enter employee's phone number \n -------------------");
        String phoneNumber = sc.next();

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setEmail(email);
        employee.setBadgeNo(badgeNumber);
        employee.setPhoneNumber(phoneNumber);

        try {
            if (service.updateEmployee(employee, db)) {
                System.out.println("|--- Employee's details has been successfully updated");
                managerScreen();
            }

        } catch (ExceptionHandler e) {
            System.out.println("---------------- \n " + e.getMessage() + "\n ------------------");
            managerScreen();
        }


    }

    public static void searchEmployee() {

        System.out.println("----------- \n To Search employee by their badge number \n ---------");
        System.out.println("Please enter employee's badge number to get employee's details\n -----------");
        String badgeNo=sc.next();
        try{
            System.out.println(service.searchEmployee(badgeNo,db));
            managerScreen();
        }
        catch (ExceptionHandler e){
            System.out.println("---------------- \n " + e.getMessage() + "\n ------------------");
            managerScreen();
        }

    }

    public static void deleteEmployee() {
        System.out.println("----------- \n To Delete employee by their badge number \n ---------");

        System.out.println("----------- \n Are you sure you want to delete an employee, press y for yes or n for no: \n ---------");
        String choice= sc.next();
        if(choice.equalsIgnoreCase("y")) {

            System.out.println("--------- \n Please enter employee's badge number to get employee's details\n -----------");
            String badgeNo = sc.next();
        }
        else if(choice.equalsIgnoreCase("n")){
            managerScreen();
        }
        else{
            System.out.println("--------- \n Please choose a suitable option:\n -----------");
            deleteEmployee();
        }
    }

    public static void logOut() {

        try {

            System.out.println("Enter the username to logout");
            String choice = sc.next();
            if (service.logout(choice)) {


                System.out.println("Are you sure you want to log out? If yes press y and if no press n");

                String choice1 = sc.next();
                if (choice1.equalsIgnoreCase("y")) {
                    managerLogin();
                } else if (choice1.equalsIgnoreCase("n")) {
                    managerScreen();
                }
            }


        } catch (ExceptionHandler e) {
            System.out.println(e.getMessage());
            count++;
            if (count == 3) {
                System.out.println("Application has been terminated because you inputted the wrong username more than twice ");
                System.exit(0);
            }
            System.out.println("Logout unsuccessful");
            logOut();
        }


    }

}
