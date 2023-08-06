package com.bean;

public class Order {
	private int oid;
	private int cid;
	private int itemid;
	private int qty;
	private String ostatus;
	private String paystatus;
	
	public Order() {
		super();
	}
	public Order(int oid, int cid, int itemid, int qty,String ostatus, String paystatus) {
		super();
		this.oid = oid;
		this.cid = cid;
		this.itemid = itemid;
		this.qty = qty;
		this.ostatus = ostatus;
		this.paystatus = paystatus;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	public String getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", cid=" + cid + ", itemid=" + itemid + ", qty=" + qty + ", ostatus=" + ostatus + ", paystatus=" + paystatus + "]";
	}
	

}
