package com.vishal.iterator;

import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {

    private boolean isFirst;
    private LinkedList<Integer> firstList;
    private LinkedList<Integer> secondList;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        isFirst = true;
        firstList = new LinkedList<>(v1);
        secondList = new LinkedList<>(v2);
    }

    public int next() {
        Integer curr = null;
        if((isFirst && firstList.size() > 0) || secondList.size() == 0){
            curr = firstList.removeFirst();
            isFirst = false;
        }else if(secondList.size() > 0 || firstList.size() == 0){
            curr = secondList.removeFirst();
            isFirst = true;
        }
        return curr;
    }

    public boolean hasNext() {
        return firstList.size() > 0 || secondList.size() > 0;
    }

}
