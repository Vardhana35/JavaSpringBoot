package com.tcs.threads;

public class SampleThread extends Thread {

	private String msg;

	public SampleThread(String msg) {
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
