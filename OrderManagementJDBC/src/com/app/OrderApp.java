package com.app;

import java.util.Scanner;

public class OrderApp {

	public static void main(String[] args) {
		char ch = ' ';
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("----------------------------------------------------");
			System.out.println("-------------Order Management System----------------");
			System.out.println("----------------------------------------------------");
			System.out.println("1. Item Panel");
			System.out.println("2. Customer Panel");
			System.out.println("3. Order Panel");
			System.out.println("4. Exit");
			System.out.println("Enter your choice:");
			int c= sc.nextInt();
			switch(c)
			{
			case 1: ItemPanel.main(null);
			        break;
			case 2: CustomerPanel.main(null);
			        break;
			case 3: OrderPanel.main(null);
			        break;
			case 4: System.exit(0);
	        break;
			default: System.out.println("Invalid in input");
			System.out.println("---------------------------");
			System.out.println("do you want to continue");
			ch= sc.next().charAt(0);
			}	
		}
		while(ch=='Y' || ch=='y');
		sc.close();

	}

}
