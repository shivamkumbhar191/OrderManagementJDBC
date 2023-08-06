package com.app;

import java.util.Scanner;

import com.implementation.ItemImple;

public class ItemPanel {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ItemImple im=new ItemImple();
		char ch=' ';
		do {
			System.out.println("-------------Item Panel-------------------");
			System.out.println("1. Add Item");
			System.out.println("2. Delete Item");
			System.out.println("3. Update Item cost");
			System.out.println("4. Display all Items");
			System.out.println("5. Search Item by id");
			System.out.println("6. Exit Item Panel");
			System.out.println("enter the choice");
			int c=sc.nextInt();
			switch(c) {
			case 1:im.addItem();
			break;
			case 2:im.deleteItem();
			break;
			case 3:im.updateItem();
			break;
			case 4:im.displayAllItem();
			break;
			case 5:im.getItemById();
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
