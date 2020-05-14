package com.vishal.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class BufferProducerConsumer {
	int capacity ;
	private Queue<Integer> bufferList;
	
	public BufferProducerConsumer(int cap) {
		this.capacity = cap;
		bufferList = new LinkedList<>();
	}
	
	
	public synchronized void producer() {
		int value = 0;
		for(int i = 0 ;i<10;i++) {
			while (bufferList.size() >= capacity) {
                // wait for the consumer
                try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
			bufferList.add(value);
            System.out.println("Produced " + value);
            value++;
            // notify the consumer
            notify();
		}
	}
	
	public synchronized void consumer() {
		for(int i = 0 ;i<10;i++) {
			while (bufferList.size() == 0) {
                // wait for the producer
	            try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
            int value = bufferList.poll();
            System.out.println("Consume " + value);
            // notify the producer
            notify();
        }
	}

}
