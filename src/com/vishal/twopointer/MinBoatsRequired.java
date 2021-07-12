package com.vishal.twopointer;

import java.util.Arrays;

public class MinBoatsRequired {

    public int numRescueBoats(int[] people, int limit) {
        if(people == null || people.length == 0){
            return 0;
        }
        int minBoats = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        //left being at min weight
        //right being at max weight
        while(left <= right){
            if(people[left] + people[right] <= limit){
                minBoats++;
                left++;
                right--;
            }else{
                minBoats++;
                right--;
            }
        }
        return minBoats;
    }

}
