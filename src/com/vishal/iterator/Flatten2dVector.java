package com.vishal.iterator;

import java.util.LinkedList;

public class Flatten2dVector {

    private LinkedList<Integer> list;

    public Flatten2dVector(int[][] vec) {
        list = new LinkedList<>();
        for(int i = 0; i < vec.length; i++){
            int[] arr = vec[i];
            for(int num: arr){
                list.add(num);
            }
        }
    }

    public int next() {
        Integer curr = list.removeFirst();
        return curr;
    }

    public boolean hasNext() {
        return list.size() > 0;
    }

}
