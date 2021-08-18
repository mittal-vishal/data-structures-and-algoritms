package com.vishal.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair{
    int value;
    int pos;
    int index;
    public Pair(int value, int pos, int index){
        this.value = value;
        this.pos = pos;
        this.index = index;
    }
}

public class MergeKSortedArray {

    public List<Integer> mergeKSortedArr(List<List<Integer>> lists){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.value-b.value);
        for(int i  = 0; i < lists.size(); i++){
            pq.offer(new Pair(lists.get(i).get(0), i, 0));
        }
        List<Integer> mergeList = new ArrayList<>();
        while(!pq.isEmpty()){
            Pair poppedPair = pq.poll();
            mergeList.add(poppedPair.value);
            int index = poppedPair.index + 1;
            int pos = poppedPair.pos;
            if(index < lists.get(pos).size()){
                pq.offer(new Pair(lists.get(pos).get(index), pos, index));
            }
        }
        return mergeList;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(5,12);
        List<Integer> list2 = Arrays.asList(1,4,7);
        List<Integer> list3 = Arrays.asList(3, 6,9);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        MergeKSortedArray mergeArrClass = new MergeKSortedArray();
        List<Integer> mergeList = mergeArrClass.mergeKSortedArr(lists);
        System.out.print(mergeList);
    }

}
