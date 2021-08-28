package com.vishal.google;

import java.util.*;
import java.util.stream.Collectors;

public class RecoverList {

    public static void main(String[] args) {
        //Given original array of random integer
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 8};
        //Given array of integer whose value is double than given orig array
        int[] doubleEleArr = {2, 4, 4, 4, 6, 6, 8, 16};
        //Original array and double element arrays values are shuffled and merge into new array
        int[] mergeArr = {6, 2, 4, 2, 8, 2, 2, 4, 6, 8, 4, 1, 3, 4, 16, 3};
        //From merge array restore the orig arrays
        List<List<Integer>> resultList = restoreList(mergeArr);
        System.out.print(resultList);
    }

    private static List<List<Integer>> restoreList(int[] mergeArr) {
        List<Integer> origList = new ArrayList<>();
        List<Integer> origDoubleList = new ArrayList<>();
        List<Integer> mergeList = Arrays.stream(mergeArr).boxed().collect(Collectors.toList());
        Collections.sort(mergeList);
        HashMap<Integer, Integer> elementOccurMap = new HashMap<>();
        //Store occurance of all element of merge list in map
        for(int element: mergeList){
            elementOccurMap.put(element, elementOccurMap.getOrDefault(element, 0) + 1);
        }
        for(int element: mergeList){
            if(elementOccurMap.get(element) > 0){
                origList.add(element);
                origDoubleList.add(2*element);
                elementOccurMap.put(element, elementOccurMap.get(element) - 1);
                elementOccurMap.put(2*element, elementOccurMap.get(2*element) - 1);
            }
        }
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(origList);
        resList.add(origDoubleList);
        return resList;
    }

}
