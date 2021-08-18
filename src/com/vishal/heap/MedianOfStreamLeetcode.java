package com.vishal.heap;

import java.util.PriorityQueue;

public class MedianOfStreamLeetcode {

    class MedianFinder {

        private PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a,b) -> b-a);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(minHeap.size() < maxHeap.size()){
                if(num > maxHeap.peek()){
                    minHeap.offer(num);
                }else{
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                }
            }else{
                if(!minHeap.isEmpty() && minHeap.peek() < num){
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                }else{
                    maxHeap.offer(num);
                }
            }
        }

        public double findMedian() {
            int size = minHeap.size() + maxHeap.size();
            double median = 0d;
            if(size % 2 == 0){
                median = (minHeap.peek() + maxHeap.peek())/2d;
            }else{
                median = maxHeap.peek()/1d;
            }
            return median;
        }
    }

}
