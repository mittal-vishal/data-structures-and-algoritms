package com.vishal.amazon;


/*
*
* class Element{
*   int index;
*   int occurance
* }
*
* [1,2,1,4,5, 5,6, 2]
* HashMap<Integer,Element>
* */

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class NonRepeatingInteger {

    static class Element{
        int occurance;
        int index;
        public Element(int occurance, int index){
            this.index = index;
            this.occurance = occurance;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,4,2,4};
        int result = getNonRepeatingElement(nums);
        System.out.println(result);
    }

    private static int getNonRepeatingElement(int[] nums){
        //base case handeling
        if(nums == null || nums.length == 0){
            return -1;
        }
        //store the occurances and index of each unique element in map
        HashMap<Integer, Element> occurances = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!occurances.containsKey(nums[i])){
                occurances.put(nums[i], new Element(1, i));
            }else{
                Element existingElement = occurances.get(nums[i]);
                occurances.put(nums[i], new Element(existingElement.occurance + 1, i));
            }
        }
        int result = -1;
        int maxIndex = nums.length-1;
        for(Map.Entry<Integer,Element> entry: occurances.entrySet()){
            if(entry.getValue().occurance == 1 && entry.getValue().index < maxIndex){
                maxIndex = entry.getValue().index;
                result = entry.getKey();
            }
        }
        return result;
    }

}
