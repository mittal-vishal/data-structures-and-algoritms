package com.vishal.concurrency;

public class ResourceMain {

	public static void main(String[] args) {
		int maxNumber = 10;
		int threadCount = 3;
		SharedResource sr = new SharedResource(threadCount, maxNumber);
		ResourceRunnable resourceRunnableOne = new ResourceRunnable(sr, 1);
		ResourceRunnable resourceRunnableTwo = new ResourceRunnable(sr, 2);
		ResourceRunnable resourceRunnableThree = new ResourceRunnable(sr, 0);
		Thread threadOne = new Thread(resourceRunnableOne, "Thread 1");
		Thread threadTwo = new Thread(resourceRunnableTwo, "Thread 2");
		Thread threadThree = new Thread(resourceRunnableThree, "Thread 3");
		threadTwo.start();
		threadOne.start();
		threadThree.start();
	}

}
