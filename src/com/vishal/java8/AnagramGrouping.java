package com.vishal.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnagramGrouping {

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		FunctionalInterfaceAnagram f = (String[] words) -> {
			Set<Set<String>> outputSet = new HashSet<>();
	        Map<String, Set<String>> map = new HashMap<>();
	        String sortStr = null;
	        char[] sortStrArray = null;
	        Set<String> set = null;
	        for(String str : strs){
	            sortStrArray = str.toCharArray();
	            Arrays.sort(sortStrArray);
	            sortStr = String.valueOf(sortStrArray);
	            if(!map.containsKey(sortStr)){
	                set = new HashSet<>();
	                set.add(str);
	                map.put(sortStr, set);
	            }else{
	            	set = map.get(sortStr);
	            	set.add(str);
	                map.put(sortStr, set);
	            }
	        }
	        
	        outputSet.addAll(map.values());
	        
	        return outputSet;
			
		};
		
		System.out.println(f.anagrapGrouping(strs));

	}

}
