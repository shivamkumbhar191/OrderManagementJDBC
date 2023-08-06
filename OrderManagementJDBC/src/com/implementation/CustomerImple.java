package com.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.bean.Customer;
import com.connect.DBConnectionOrder;
import com.dao.CustomerDao;

public class CustomerImple implements CustomerDao{
	Connection conn=null;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	
	Scanner sc = new Scanner(System.in);
	Customer c= new Customer();
	public CustomerImple() {
		conn=DBConnectionOrder.getConnect();
		try {
			st=conn.createStatement();
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	@Override
	public void addCustomer() {
		System.out.println("Enter the customer id:");
        c.setCid(sc.nextInt());
        System.out.println("Enter first name:");
        c.setFname(sc.next());
        System.out.println("Enter last name:");
        c.setLname(sc.next());
        System.out.println("Enter mobile no:");
        c.setMobno(sc.nextLong());
        System.out.println("Enter email:");
        c.setEmail(sc.next());
        System.out.println("Enter address:");
        c.setAddress(sc.next());
        try {
			pst=conn.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			pst.setInt(1,c.getCid());
			pst.setString(2,c.getFname());
			pst.setString(3,c.getLname());
			pst.setLong(4,c.getMobno());
			pst.setString(5,c.getEmail());
			pst.setString(6,c.getAddress());
			int row=pst.executeUpdate();
			if(row>0) {
				System.out.println("customer Added...");
			}else {
				System.out.println("customer not Added");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer() {
		System.out.println("enter the customer id");
		int cid=sc.nextInt();
		try {
			pst=conn.prepareStatement("delete from customer where cid=?");
			pst.setInt(1,cid);
			if(pst.executeUpdate()>0) {
				System.out.println("Customer Deleted successfully...");
			}else {
				System.out.println("customer not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void updateCustomer() {
		System.out.println("enter the customer id");
		int cid=sc.nextInt();
		try {
			pst=conn.prepareStatement("update customer set mobileno=? where cid=?");
			//System.out.println("old mobile number :");
			System.out.println("enter the new mobile number");
			long mobno=sc.nextLong();
			pst.setLong(1, mobno);
			pst.setInt(2, cid);
			if(pst.executeUpdate()>0) {
				System.out.println("Customer updated");
			}else {
				System.out.println("Customer not found");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void getCustomerById() {
		System.out.println("enter the customer id");
		int cid= sc.nextInt();
		try {
			pst=conn.prepareStatement("select * from customer where cid=?");
			pst.setInt(1, cid);
			rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)
				+" "+rs.getLong(4)+" "+rs.getString(5)+" "+rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void displayAllCustomer() {
		try {
			pst=conn.prepareStatement("select * from customer");
			rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)
				+" "+rs.getLong(4)+" "+rs.getString(5)+" "+rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
