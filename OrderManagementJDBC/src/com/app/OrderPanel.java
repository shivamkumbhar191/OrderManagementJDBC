package com.app;

import java.util.Scanner;

import com.implementation.OrderImple;

public class OrderPanel {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		OrderImple om=new OrderImple();
		char ch=' ';
		do {
			System.out.println("-------------Order Panel-------------------");
			System.out.println("1. Add Order");
			System.out.println("2. Delete Order");
			System.out.println("3. Update Item Quntity");
			System.out.println("4. Display all Orders");
			System.out.println("5. Search Order by id");
			System.out.println("6. Exit Order Panel");
			System.out.println("enter the choice");
			int c=sc.nextInt();
			switch(c) {
			case 1:om.addOrder();
			break;
			case 2:om.deleteOrder();
			break;
			case 3:om.updateOrder();
			break;
			case 4:om.displayAllOrder();
			break;
			case 5:om.getOrderById();
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
