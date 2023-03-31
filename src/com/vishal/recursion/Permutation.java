package com.vishal.recursion;

import java.util.*;

public class Permutation {

	public List<String> find_permutation(String s) {
		List<String> result = new ArrayList<>();
		Map<Character, Integer> freqMap = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
		}
		permute(s, 0, s.length(), "", result, freqMap);
		return result;
	}

	private void permute(String s, int beg, int end, String ans, List<String>result, Map<Character, Integer> freqMap){
		if(beg == end){
			result.add(ans);
			return;
		}
		for(char ch: freqMap.keySet()){
			int currCharFreq = freqMap.get(ch);
			if(freqMap.get(ch) > 0){
				freqMap.put(ch, currCharFreq - 1);
				permute(s, beg + 1, end, ans + ch, result, freqMap);
				freqMap.put(ch, currCharFreq);
			}
		}
	}

	private static List<String> returnList = new ArrayList<>();
	
	public static void main(String args[]) {
		//permutation("abc", "");
		//System.out.println(returnList);
		int[] nums = {1, 2, 3};
		List<List<Integer>>permuteList = permute(nums);
		System.out.println(permuteList);
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permuteList = new ArrayList<>();
		permute(nums, permuteList, 0);
		return permuteList;
	}

	private static void permute(int[] nums, List<List<Integer>> permuteList, int i){
		if(i == nums.length - 1){
			List<Integer> permutations = new ArrayList<>();
			for(int element: nums){
				permutations.add(element);
			}
			permuteList.add(permutations);
			return;
		}
		for(int j = i; j < nums.length; j++){
			swapIndices(nums, j, i);
			permute(nums, permuteList, i+1);
			swapIndices(nums, j, i);
		}
	}

	private static void swapIndices(int[] nums, int j, int i){
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}

	private static void permutation(String str, String output) {
		if (str.length() == 0) {
			returnList.add(output);
		}
		for (int i = 0; i < str.length(); i++) {
			String ros = str.substring(0, i) + str.substring(i + 1);
			permutation(ros, output + str.charAt(i));
		}
	}

}
