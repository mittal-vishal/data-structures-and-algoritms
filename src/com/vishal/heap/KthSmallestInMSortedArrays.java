package com.vishal.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Element{
    Integer val;
    int index;
    int listIndex;
    public Element(Integer val, int index, int listIndex){
        this.val = val;
        this.index = index;
        this.listIndex = listIndex;
    }
}
class KthSmallestInMSortedArrays {

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i = 0; i < lists.size(); i++){
            pq.offer(new Element(lists.get(i)[0], 0, i));
        }
        while(!pq.isEmpty() && k-- > 0){
            Element lowestElement = pq.poll();
            if(k == 0){
                return lowestElement.val;
            }
            if(lists.get(lowestElement.listIndex).length > lowestElement.index + 1){
                pq.offer(new Element(lists.get(lowestElement.listIndex)[lowestElement.index + 1], lowestElement.index + 1, lowestElement.listIndex));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 5, 8, 9 };
        Integer[] l2 = new Integer[] { 1, 7 };
        List<Integer[]> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 3);
        System.out.print("Kth smallest number is: " + result);
    }
}
