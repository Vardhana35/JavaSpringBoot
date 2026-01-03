package com.tcs.threads;

//preventing multiple threads accessing  the same resource->synchronization
public class Printer {

	// synchronization at method level
	/*
	 * public synchronized void print(String msg) { for(int i=0;i<10;i++) {
	 * System.out.println(msg); try { Thread.sleep(100); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } }
	 */

	// block level synchronization
	public void print(String msg) {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println(msg);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
