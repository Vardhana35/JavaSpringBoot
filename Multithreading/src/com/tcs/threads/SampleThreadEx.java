package com.tcs.threads;

public class SampleThreadEx {

	public static void main(String[] args) {

		long ms = System.currentTimeMillis();
		SampleThread t1 = new SampleThread("hello");
		SampleThread t2 = new SampleThread("bye");
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long es = System.currentTimeMillis();
		System.out.println("Completed....." + (es - ms));

	}

}
