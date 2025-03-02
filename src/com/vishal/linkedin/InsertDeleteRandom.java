package com.vishal.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;

public class InsertDeleteRandom {

    private ArrayList<Integer> elements;
    private HashMap<Integer, LinkedHashSet<Integer>> elementIndices;
    private Random random;

    public InsertDeleteRandom() {
        random = new Random();
        elements = new ArrayList<>();
        elementIndices = new HashMap<>();
    }

    public boolean insert(int val) {
        elementIndices.putIfAbsent(val, new LinkedHashSet<>());
        int index = elements.size();
        elementIndices.get(val).add(index);
        elements.add(val);
        return elementIndices.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if(!elementIndices.containsKey(val) || elementIndices.get(val).size() == 0){
            return false;
        }
        LinkedHashSet<Integer> indices = elementIndices.get(val);
        int indexToBeDeleted = indices.iterator().next();
        int lastElement = elements.get(elements.size()-1);
        //update element index
        elements.set(indexToBeDeleted, lastElement);
        elementIndices.get(lastElement).remove(elements.size()-1);
        elementIndices.get(val).remove(indexToBeDeleted);
        elementIndices.get(lastElement).add(indexToBeDeleted);
        elements.remove(elements.size()-1);
        return true;
    }

    public int getRandom() {
        int randomIdx = random.nextInt(elements.size());
        return elements.get(randomIdx);
    }

    public static void main(String[] args) {
        InsertDeleteRandom insertDeleteRandom = new InsertDeleteRandom();
        insertDeleteRandom.insert(4);
        insertDeleteRandom.insert(3);
        insertDeleteRandom.insert(4);
        insertDeleteRandom.insert(2);
        insertDeleteRandom.insert(4);
        insertDeleteRandom.remove(4);
        insertDeleteRandom.remove(3);
        insertDeleteRandom.remove(4);
        insertDeleteRandom.remove(4);
    }

    /*
    "RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","remove"
    [4],[3],[4],[2],[4],[4],[3],[4],[4]]
    * */

}
