package com.vishal.binarytree;

import java.util.*;
import java.util.Map.Entry;

public class TopView {

	static class Pair{
		int data;
		int level;
		public Pair(int data, int level){
			this.data = data;
			this.level = level;
		}
	}
	//Function to return a list of nodes visible from the top view
	//from left to right in Binary Tree.
	private ArrayList<Integer> topView(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		TreeMap<Integer, List<Pair>> map = new TreeMap<>();
		dfs(root, 0, 0, map);
		for(Map.Entry<Integer, List<Pair>> entry: map.entrySet()){
			List<Pair> elements = entry.getValue();
			Collections.sort(elements, (a,b) -> a.level-b.level);
			result.add(elements.get(0).data);
		}
		return result;
	}

	private void dfs(TreeNode root, int level, int vertical, TreeMap<Integer, List<Pair>> map){
		if(root == null){
			return;
		}
		map.putIfAbsent(vertical, new ArrayList<>());
		map.get(vertical).add(new Pair(root.val, level));
		dfs(root.left, level + 1, vertical - 1, map);
		dfs(root.right, level + 1, vertical + 1, map);
	}

}
