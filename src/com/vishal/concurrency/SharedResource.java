package com.vishal.concurrency;

public class SharedResource {
	
	private volatile int number = 1;
	private int threadCount;
	private int maxNumber;
	
	public SharedResource(int threadCount, int maxNumber) {
		this.threadCount = threadCount;
		this.maxNumber = maxNumber;
	}
	
	public void printNumbers(int result) {
		synchronized (this) {
			while(number <= maxNumber - (threadCount - 1)) {
				while(number % threadCount != result) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " value = " + number++);
				this.notifyAll();
			}
		}
	}

}
