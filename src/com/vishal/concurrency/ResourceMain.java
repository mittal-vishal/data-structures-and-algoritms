package com.vishal.concurrency;

public class ResourceMain {

	public static void main(String[] args) {
		int maxNumber = 10;
		int threadCount = 2;
		SharedResource sr = new SharedResource(threadCount, maxNumber);
		ResourceRunnable resourceRunnableOne = new ResourceRunnable(sr, 0);
		ResourceRunnable resourceRunnableTwo = new ResourceRunnable(sr, 1);
		Thread threadOne = new Thread(resourceRunnableOne, "Thread 1");
		Thread threadTwo = new Thread(resourceRunnableTwo, "Thread 2");
		threadTwo.start();
		threadOne.start();
	}

}
