package com.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bean.Item;
import com.bean.Order;
import com.connect.DBConnectionOrder;
import com.dao.OrderDao;

public class OrderImple implements OrderDao{
	Scanner sc= new Scanner(System.in);
	Order o=new Order();
	Item im= new Item();
	Connection conn=null;
	PreparedStatement pst1,pst;
	ResultSet rs,rs1;
	Statement st;
	
	public OrderImple() {
		conn=DBConnectionOrder.getConnect();
		try {
			st=conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public float totalCost(int iid,int qty) {
		float totalcost=0;
		try {
			pst1=conn.prepareStatement("select * from item");
			rs=pst1.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==iid) {
					totalcost=rs.getFloat(3)*qty;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		//System.out.println( "total cost for item id "+iid+" is "+totalcost);
		return totalcost; 
	}

	@Override
	public void addOrder() {
		System.out.println("enter the order id");
		o.setOid(sc.nextInt());
		System.out.println("enter the customer id");
		o.setCid(sc.nextInt());
		System.out.println("enter the item id");
		int iid=sc.nextInt();
		o.setItemid(iid);
		System.out.println("enter the item quntity");
		int qty=sc.nextInt();
		o.setQty(qty);

		System.out.println("enter the order status");
		o.setOstatus(sc.next());
		System.out.println("enter the payment status");
		o.setPaystatus(sc.next());
			
		try {
			pst=conn.prepareStatement("insert into orders values(?,?,?,?,?,?,?)");
			pst.setInt(1,o.getOid());
			pst.setInt(2,o.getCid());
			pst.setInt(3, o.getItemid());
			pst.setInt(4,o.getQty());
			pst.setFloat(5,totalCost(iid,qty));
			pst.setString(6,o.getOstatus());
			pst.setString(7,o.getPaystatus());
			if(pst.executeUpdate()>0) {
				System.out.println("Order added");
			}else {
				System.out.println("Order not added");
			}
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteOrder() {
		System.out.println("enter the order id");
		int oid=sc.nextInt();
		try {
			pst=conn.prepareStatement("delete from orders where order_id=?");
			pst.setInt(1, oid);
			if(pst.executeUpdate()>0) {
				System.out.println("order deleted successfully...");
			}else {
				System.out.println("order not deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrder() {
		System.out.println("enter the order id");
		int oid=sc.nextInt();
		System.out.println("enter the new quntity");
		int qty=sc.nextInt();
		try {
			int noOfRowsUpdated=st.executeUpdate("update orders set qty="+qty+",totalCost="+totalCost(updatedCost(oid), qty)+" where order_id="+oid);
			if(noOfRowsUpdated>0){
				System.out.println("Order quntity Updated...");
			}else {
				System.out.println("quntity not updated");
			}
			
//			pst=conn.prepareStatement("update orders set qty=?,totalCost=? where order_id="+oid);
//			System.out.println("enter the new quntity");
//			qty=sc.nextInt();
//			pst.setInt(1,qty);
//			pst.setFloat(2,totalCost(updatedCost(oid), qty));
//			pst.setInt(3, oid);
//			if(pst.executeUpdate()>0) {
//				System.out.println("Order quntity Updated...");
//			}else {
//				System.out.println("quntity not updated");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		updatedCost(oid);
	}
	public int updatedCost(int oid) {
		int iid=0;
		try {
			pst=conn.prepareStatement("select * from orders");
			rs=pst.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==oid) {	
					iid=rs.getInt(3);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return iid;
	}

	@Override
	public void getOrderById() {
		System.out.println("enter the order id");
		int oid=sc.nextInt();
		try {
			pst=conn.prepareStatement("select * from orders where order_id=?");
			pst.setInt(1, oid);
			rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+
						+rs.getFloat(5)+" "+rs.getString(6)+" "+rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void displayAllOrder() {
		try {
			pst=conn.prepareStatement("select * from orders");
			rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+
						+rs.getFloat(5)+" "+rs.getString(6)+" "+rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
