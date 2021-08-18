package com.vishal.heap;

import java.util.PriorityQueue;

public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        int left = 0;
        int right = 0;

        int index = 0;

        while(right < nums.length){
            //Expand the window
            int num = nums[right++];
            if(maxHeap.size() <= minHeap.size()){
                if(!minHeap.isEmpty() && num > minHeap.peek()){
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                }else{
                    maxHeap.offer(num);
                }
            }else{
                if(!maxHeap.isEmpty() && num < maxHeap.peek()){
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                }else{
                    minHeap.offer(num);
                }
            }
            //Shrink the window
            if((right-left) > k){
                int deleteNum = nums[left++];
                if(minHeap.contains(deleteNum)){
                    minHeap.remove(deleteNum);
                    if(Math.abs(maxHeap.size() - minHeap.size()) > 1){
                        minHeap.offer(maxHeap.poll());
                    }
                }else{
                    maxHeap.remove(deleteNum);
                    if(Math.abs(maxHeap.size() - minHeap.size()) > 1){
                        maxHeap.offer(minHeap.poll());
                    }
                }
            }

            if((right - left) == k){
                //Calculate median
                int size = minHeap.size() + maxHeap.size();
                if(size % 2 == 0){
                    double minHeapVal = minHeap.peek();
                    double maxHeapVal = maxHeap.peek();
                    res[index++] = (minHeapVal + maxHeapVal)/2d;
                }else{
                    if(minHeap.size() > maxHeap.size()){
                        res[index++] = minHeap.peek()/1d;
                    }else{
                        res[index++] = maxHeap.peek()/1d;
                    }
                }
            }
        }
        return res;
    }

}
