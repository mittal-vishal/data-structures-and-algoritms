package com.vishal.string;

import java.util.ArrayList;
import java.util.List;

public class AtivateDeactivateNeighbours {

	public static void main(String[] args) {
		int[] states = {1,1,1,0,1,1,1,1};
		int days = 2;
		System.out.println(cellCompete(states, days));

	}
	
	public static List<Integer> cellCompete(int[] states, int days)
    {
    // WRITE YOUR CODE HERE
        int prev = 0, next = 0;
        int[] output = null;
        while(days-- > 0){
        	output = new int[states.length];
            for(int i=0;i<states.length;i++){
                next = (i <= states.length-2) ? states[i+1] : 0;
                prev = i >= 1 ? states[i-1] : 0;
                if(prev == next){
                    output[i] = 0;
                }else{
                    output[i] = 1;
                }
            }
            states = output;
        }
        List<Integer> list = new ArrayList<>();
        for(int i : output){
            list.add(i);
        }
        return list;
    }

}
