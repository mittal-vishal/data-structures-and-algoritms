package com.vishal.collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueCollection {

	public static void main(String[] args) {
		Queue<Integer> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(1);
		priorityQueue.add(2);
		priorityQueue.add(3);
		System.out.println(priorityQueue);
		System.out.println("peek::" + priorityQueue.peek());
		System.out.println("poll" + priorityQueue.poll());
		System.out.println(priorityQueue);
		priorityQueue.remove();
		System.out.println(priorityQueue);

	}

}
