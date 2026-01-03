package com.tcs.threads;

public class MyThreadEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long ms= System.currentTimeMillis();
		
		/*MyThread m1=new MyThread("hello");
		MyThread m2=new MyThread("bye");
		
		Thread t1=new Thread(m1);
		Thread t2=new Thread(m2);*/
		
		Thread t1=new Thread(new MyThread("hello"));
		Thread t2=new Thread(new MyThread("bye"));
		
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
