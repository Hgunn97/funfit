package com.funfit.bean;

public class Participants {
	private int pid;
	private String fname;
	private int age;
	private String phonenumber;
	private int bid;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "Participants [pid=" + pid + ", fname=" + fname + ", age=" + age + ", phonenumber=" + phonenumber + ", bid="
				+ bid + "]";
	}
	public Participants() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Participants(int pid, String fname, int age, String phonenumber, int bid) {
		super();
		this.pid = pid;
		this.fname = fname;
		this.age = age;
		this.phonenumber = phonenumber;
		this.bid = bid;
	}

}