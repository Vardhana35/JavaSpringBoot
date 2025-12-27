package com.tcs.Handson.interfaces;

public class RBIMain {

	public static void main(String[] args) {
		Bank b;
		b=new ICICI();
		b.deposit();
		b.displayBalance();
		
	}
}