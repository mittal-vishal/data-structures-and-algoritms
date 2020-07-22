package com.vishal.goldmansachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGrouping {

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> outputList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        String sortStr = null;
        char[] sortStrArray = null;
        List<String> list = null;
        for(String str : strs){
            sortStrArray = str.toCharArray();
            Arrays.sort(sortStrArray);
            sortStr = String.valueOf(sortStrArray);
            if(!map.containsKey(sortStr)){
                list = new ArrayList<>();
                list.add(str);
                map.put(sortStr, list);
            }else{
                list = map.get(sortStr);
                list.add(str);
                map.put(sortStr, list);
            }
        }
        
        outputList.addAll(map.values());
        
        return outputList;
	}

}
