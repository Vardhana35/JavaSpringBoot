package com.tcs.threads;

//multiple threads running in parallel
//multiple tasks running simultaneously
public class MyThread implements Runnable {

	private String msg;

	public MyThread(String msg) {
		super();
		this.msg = msg;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(msg);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
