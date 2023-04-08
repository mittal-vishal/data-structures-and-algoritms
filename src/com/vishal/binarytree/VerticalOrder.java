package com.vishal.binarytree;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class VerticalOrder {

	class Pair{
		int val;
		int level;
		public Pair(int val, int level){
			this.val = val;
			this.level = level;
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		TreeMap<Integer, List<Pair>> map = new TreeMap<>();
		dfs(root, 0, 0, map);
		List<List<Integer>> results = new ArrayList<>();
		for(Map.Entry<Integer, List<Pair>> entry: map.entrySet()){
			List<Pair> elements = entry.getValue();
			Collections.sort(elements, (a,b) -> {
				if(a.level != b.level){
					return a.level-b.level;
				}else{
					return a.val-b.val;
				}
			});
			List<Integer> elementValues = elements.stream().map(a -> a.val).collect(Collectors.toList());
			results.add(elementValues);
		}
		return results;
	}

	private void dfs(TreeNode root, int level, int vertical, TreeMap<Integer, List<Pair>> map){
		if(root == null){
			return;
		}
		map.putIfAbsent(vertical, new ArrayList<>());
		map.get(vertical).add(new Pair(root.val, level));
		dfs(root.left, level+1, vertical-1, map);
		dfs(root.right, level+1, vertical+1, map);
	}

}
