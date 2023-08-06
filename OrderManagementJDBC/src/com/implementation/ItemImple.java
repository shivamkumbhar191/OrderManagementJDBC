package com.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bean.Item;
import com.connect.DBConnectionOrder;
import com.dao.ItemDao;

public class ItemImple implements ItemDao {
	Scanner sc= new Scanner(System.in);
	Item im=new Item();
	Connection conn=null;
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	
	public ItemImple() {
		conn=DBConnectionOrder.getConnect();
		try {
			st=conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addItem() {
		System.out.println("enter the item id");
		int iid=sc.nextInt();
		System.out.println("enter the item name");
		String iname=sc.next();
		System.out.println("enter the item cost");
		float cost=sc.nextFloat();
		im.setItemid(iid);
		im.setIname(iname);
		im.setCost(cost);
		try {
			pst=conn.prepareStatement("insert into item values(?,?,?)");
			pst.setInt(1,im.getItemid());
			pst.setString(2,im.getIname());
			pst.setFloat(3, im.getCost());
			if(pst.executeUpdate()>0) {
				System.out.println("item added");
			}else {
				System.out.println("item not added");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteItem() {
		System.out.println("enter the item id");
		int iid=sc.nextInt();
		try {
			pst=conn.prepareStatement("delete from item where item_id=?");
			pst.setInt(1, iid);
			if(pst.executeUpdate()>0) {
				System.out.println("item deleted successfully...");
			}else {
				System.out.println("item not deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateItem() {
		System.out.println("enter the item id");
		int iid=sc.nextInt();
		try {
			pst=conn.prepareStatement("update item set cost=? where item_id=?");
			System.out.println("enter the new cost");
			float icost=sc.nextFloat();
			pst.setFloat(1, icost);
			pst.setInt(2, iid);
			if(pst.executeUpdate()>0) {
				System.out.println("item cost Updated...");
			}else {
				System.out.println("cost not updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getItemById() {
		System.out.println("enter the item id");
		int iid=sc.nextInt();
		try {
			pst=conn.prepareStatement("select * from item where item_id=?");
			pst.setInt(1, iid);
			rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void displayAllItem() {
		try {
			pst=conn.prepareStatement("select * from item");
			rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
