package com.vishal.arrays;

import java.util.HashMap;
import java.util.Map;

public class Frequency {

	public static void main(String[] args) {
		int a[]= {2,3,2,3,5};
		printFrequency(a, a.length);
	}
	
	public static void  printFrequency(int arr[], int n){
        
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i : arr) {
        	if(!map.containsKey(i)) {
        		map.put(i, 1);
        	}else {
        		map.put(i, map.get(i) + 1);
        	}
        }
        
        StringBuffer sb = new StringBuffer();
    	for(int i=1;i<=n;i++){
    	    if(map.containsKey(i)){
    	        sb.append(map.get(i)).append(" ");
    	    }else{
    	        sb.append(0).append(" ");
    	    }
    	}
    	
    	System.out.print(sb.toString().trim());
        
    }

}
