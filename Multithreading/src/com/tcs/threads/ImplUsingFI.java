package com.tcs.threads;

//implementing using functional interfaces
public class ImplUsingFI {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("hello");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Completed.....hello");
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("bye");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Completed.....bye");
		});

		t1.start();
		t2.start();
	}
}
