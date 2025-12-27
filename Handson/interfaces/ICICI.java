package com.tcs.Handson.interfaces;

public class ICICI extends Bank{

	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		System.out.println("min deposit: 1000");
		
	}

	@Override
	public void withdrawl() {
		// TODO Auto-generated method stub
		System.out.println("min withdrawl: 500");
	}


	
}
