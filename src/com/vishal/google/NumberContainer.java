package com.vishal.google;

import java.util.HashMap;
import java.util.TreeSet;

public class NumberContainer {

    private HashMap<Integer,TreeSet<Integer>> elementIndices;
    private HashMap<Integer,Integer> indexElement;

    public NumberContainer() {
        elementIndices = new HashMap<>();
        indexElement = new HashMap<>();
    }

    public void change(int index, int number) {
        if(indexElement.containsKey(index)){
            int oldElement = indexElement.get(index);
            elementIndices.get(oldElement).remove(index);
        }
        elementIndices.putIfAbsent(number, new TreeSet<>());
        elementIndices.get(number).add(index);
        indexElement.put(index,number);
    }

    public int find(int number) {
        if(!elementIndices.containsKey(number) || elementIndices.get(number).isEmpty()){
            return -1;
        }else{
            return elementIndices.get(number).first();
        }
    }

}
