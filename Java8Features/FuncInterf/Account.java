package com.tcs.Java8Features.FuncInterf;

public class Account implements Comparable<Account>{

	private int accno;
	private String accname;
	private int balance;
	
	private String customerRefNo;
	
	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}


	Account(int accntno, String accname, int balance){
		this.accno=accntno;
		this.accname=accname;
		this.balance=balance;
	}
	
	void displayDetails() {
		System.out.println(accno+" "+accname+" "+balance);
	}

	@Override
	public int compareTo(Account o) {
		// TODO Auto-generated method stub
		return this.balance-o.getBalance();
	}

	public String getCustomerRefNo() {
		return customerRefNo;
	}

	public void setCustomerRefNo(String customerRefNo) {
		this.customerRefNo = customerRefNo;
	}
}
