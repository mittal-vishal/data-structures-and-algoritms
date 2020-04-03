package com.vishal.concurrency;

public class ResourceRunnable implements Runnable{
	
	private SharedResource sharedRes;
	private int result; 
	
	public ResourceRunnable(SharedResource sharedRes, int result) {
		this.sharedRes = sharedRes;
		this.result = result;
	}

	@Override
	public void run() {
		sharedRes.printNumbers(result);
	}

}
