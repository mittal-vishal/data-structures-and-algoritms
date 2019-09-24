package com.vishal.collections;

import java.util.Deque;
import java.util.LinkedList;

public class LinkedListDequeueCollection {

	public static void main(String[] args) {
		Deque<Integer> arrayDequeue = new LinkedList<>();
		arrayDequeue.add(1);
		arrayDequeue.addFirst(2);
		arrayDequeue.addLast(3);
		arrayDequeue.addFirst(4);
		System.out.println(arrayDequeue);
		System.out.println("peek::" + arrayDequeue.peekLast());
		System.out.println("poll" + arrayDequeue.pollFirst());
		System.out.println(arrayDequeue);
		arrayDequeue.removeLast();
		System.out.println(arrayDequeue);

	}

}
