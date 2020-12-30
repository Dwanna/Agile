package org.example.Main;

import org.example.Exception.ExceptionHandler;
import org.example.Service.ServiceImpl;

import java.util.Scanner;



public class MainClass {
	static Scanner sc = new Scanner(System.in);
	static ServiceImpl service = new ServiceImpl();

	public static void main(String args[]) {
		System.out.println("Select an Option");
		System.out.println("1.Login for manager");

		int choice = sc.nextInt();
		if (choice == 1) {
			managerLogin();
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
			} else {
				managerLogin();
			}
		} catch (ExceptionHandler e) {
			System.out.println("Error detected:---->" + e.getMessage());
			managerLogin();
		}

	}

	public static void managerLogOut() {
	}

}
