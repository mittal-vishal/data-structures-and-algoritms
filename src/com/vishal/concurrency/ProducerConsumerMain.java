package com.vishal.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		BufferProducerConsumer buffer = new BufferProducerConsumer(2);
		ExecutorService service = Executors.newFixedThreadPool(2);
		Thread producerThread = new Thread(() -> buffer.producer());
		Thread consumerThread = new Thread(() -> buffer.consumer());
		service.execute(producerThread);
		service.execute(consumerThread);
		service.shutdown();
	}

}
