package com.vishal.binarytree;

import java.util.*;

public class TopView {

	private TreeMap<Integer, List<Map.Entry<Integer,Integer>>> directionLevels;
	//Function to return a list of nodes visible from the top view
	//from left to right in Binary Tree.
	private ArrayList<Integer> topView(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		directionLevels = new TreeMap<>();
		dfs(root, 0, 0);
		for(Map.Entry<Integer, List<Map.Entry<Integer,Integer>>> entry: directionLevels.entrySet()){
			List<Map.Entry<Integer,Integer>> elements = entry.getValue();
			Collections.sort(elements, (a,b) -> a.getValue()-b.getValue());
			result.add(elements.get(0).getKey());
		}
		return result;
	}

	private void dfs(TreeNode root, int level, int vertical){
		if(root == null){
			return;
		}
		directionLevels.putIfAbsent(vertical, new ArrayList<>());
		directionLevels.get(vertical).add(new AbstractMap.SimpleEntry<>(root.val, level));
		dfs(root.left, level + 1, vertical - 1);
		dfs(root.right, level + 1, vertical + 1);
	}

}
