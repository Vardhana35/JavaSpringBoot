package com.tcs.threads;

public class ExComputer {

	public static void main(String[] args) {
		
		Printer p=new Printer();
		Computer c1=new Computer("one",p);
		Computer c2=new Computer("two",p);
		Computer c3=new Computer("three",p);
		c1.start();
		c2.start();
		c3.start();
	}
}
