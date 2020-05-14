package com.vishal.concurrency;

public class PrintEvenOdd {
	
	public synchronized void printEven() {
		for(int i=0;i<10;i++) {
			while(i%2 != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(i);
			notify();
		}
	}
	
	public synchronized void printOdd() {
		for(int i=0;i<10;i++) {
			while(i%2 == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(i);
			notify();
		}
	}

}
