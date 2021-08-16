package com.vishal.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> subsetList = new ArrayList<>();
		superSet(a, resultList, subsetList, 0);
		System.out.print(resultList);
	}

	private static void getSubsets(int[] a, List<List<Integer>> resultList,
								   List<Integer> subsetList, int i){
		if(i == a.length){
			resultList.add(new ArrayList(subsetList));
			return;
		}
		subsetList.add(a[i]);
		getSubsets(a, resultList, subsetList, i+1);
		subsetList.remove(subsetList.size()-1);
		getSubsets(a, resultList, subsetList, i+1);
	}

	private static void superSet(int[] a, List<List<Integer>> resultList,
								 List<Integer> subsetList, int i){
		if(i == a.length){
			resultList.add(new ArrayList<>(subsetList));
			return;
		}
		//Exclude
		superSet(a, resultList, subsetList, i+1);
		//Include
		List<Integer> superSetList = new ArrayList<>(subsetList);
		superSetList.add(a[i]);
		superSet(a, resultList, superSetList, i+1);
	}
}
