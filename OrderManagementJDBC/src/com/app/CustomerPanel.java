package com.app;

import java.util.Scanner;

import com.implementation.CustomerImple;

public class CustomerPanel {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		CustomerImple cm=new CustomerImple();
		char ch=' ';
		do {
			System.out.println("-------------Customer Panel-------------------");
			System.out.println("1. Add Customer");
			System.out.println("2. Delete Customer");
			System.out.println("3. Update Customer mobile number");
			System.out.println("4. Display all Customers");
			System.out.println("5. Search Customer by id");
			System.out.println("6. Exit Customer Panel");
			System.out.println("enter the choice");
			int c=sc.nextInt();
			switch(c) {
			case 1:cm.addCustomer();
			break;
			case 2:cm.deleteCustomer();
			break;
			case 3:cm.updateCustomer();
			break;
			case 4:cm.displayAllCustomer();
			break;
			case 5:cm.getCustomerById();
			break;
			case 6 : OrderApp.main(null);
	        break;
			default :System.out.println("Invalid choice");
			}
			System.out.println("---------------------------");
			System.out.println("do you want to continue");
			ch= sc.next().charAt(0);
		}while(ch=='Y' || ch=='y');
		sc.close();

	}

}
