package com.tcs.threads;

public class DThread1 extends Thread {

	public void run() {
		synchronized (Util.s1) {
			System.out.println("s1 is locked");
			synchronized (Util.s2) {
				System.out.println("s2 is locked");
				synchronized (Util.s3) {
					System.out.println("s3 is locked");
				}
				System.out.println("s3 is released");
			}
			System.out.println("s2 is released");
		}
		System.out.println("s1 is released");
	}
}
