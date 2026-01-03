package com.tcs.threads;

public class UtilEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DThread1 d1 = new DThread1();
		DThread2 d2 = new DThread2();

		d1.start();
		d2.start();
	}

}
