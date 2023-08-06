package com.bean;

public class Customer {
	private int cid;
	private String fname;
	private String lname;
	private long mobno;
	private String email;
	private String address;	
	public Customer() {
		super();
	}
	public Customer(int cid, String fname, String lname, long mobno, String email, String address) {
		super();
		this.cid = cid;
		this.fname = fname;
		this.lname = lname;
		this.mobno = mobno;
		this.email = email;
		this.address = address;
	}

	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public long getMobno() {
		return mobno;
	}


	public void setMobno(long mobno) {
		this.mobno = mobno;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", mobno=" + mobno + ", email="
				+ email + ", address=" + address + "]";
	}
	

}
