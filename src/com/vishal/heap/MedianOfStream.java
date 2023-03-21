package com.vishal.heap;

import java.util.PriorityQueue;

public class MedianOfStream {
	private static PriorityQueue<Integer> leftMaxHeap;
	private static PriorityQueue<Integer> rightMinHeap;


	public static void main(String[] args) {
		rightMinHeap = new PriorityQueue<>();
		leftMaxHeap = new PriorityQueue<>((a,b) -> b-a);
		addNum(1);
		addNum(2);
		System.out.println(findMedian());
		addNum(3);
		System.out.println(findMedian());
	}

	public static void addNum(int num) {
		if(leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()){
			leftMaxHeap.add(num);
		}else{
			rightMinHeap.add(num);
		}
		if(leftMaxHeap.size() > rightMinHeap.size() + 1){
			rightMinHeap.add(leftMaxHeap.poll());
		}else if(rightMinHeap.size() > leftMaxHeap.size()){
			leftMaxHeap.add(rightMinHeap.poll());
		}
	}

	public static double findMedian() {
		if(leftMaxHeap.size() == rightMinHeap.size()){
			double median = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2d;
			return median;
		}else{
			return leftMaxHeap.peek();
		}
	}
}
