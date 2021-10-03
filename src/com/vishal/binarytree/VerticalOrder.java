package com.vishal.binarytree;

import java.util.*;
import java.util.Map.Entry;

public class VerticalOrder {

	static class Pair{
		int level;
		int data;
		public Pair(int level, int data){
			this.level = level;
			this.data = data;
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> verticalList = new ArrayList<>();
		if(root == null){
			return verticalList;
		}
		Map<Integer, List<Pair>> map = new HashMap<>();
		dfs(root, 0, 0, map);
		PriorityQueue<Integer> verticalPq = new PriorityQueue<>(map.keySet());
		while(!verticalPq.isEmpty()){
			int level = verticalPq.poll();
			List<Pair> nodeList = map.get(level);
			if(nodeList.size() > 1){
				PriorityQueue<Pair> levelPq = new PriorityQueue<>((a,b) -> {
					if(a.level != b.level){
						return a.level - b.level;
					}else{
						return a.data - b.data;
					}
				});
				levelPq.addAll(nodeList);
				nodeList = new ArrayList<>();
				while(!levelPq.isEmpty()){
					nodeList.add(levelPq.poll());
				}
			}
			List<Integer> resultList = new ArrayList<>();
			for(Pair pair: nodeList){
				resultList.add(pair.data);
			}
			verticalList.add(resultList);
		}
		return verticalList;
	}

	private void dfs(TreeNode root, int vertical, int level, Map<Integer, List<Pair>> map){
		if(root == null){
			return;
		}
		if(!map.containsKey(vertical)){
			List<Pair> nodeList = new ArrayList<>();
			nodeList.add(new Pair(level, root.data));
			map.put(vertical, nodeList);
		}else{
			List<Pair> nodeList = map.get(vertical);
			nodeList.add(new Pair(level, root.data));
			map.put(vertical, nodeList);
		}
		dfs(root.left, vertical - 1, level + 1, map);
		dfs(root.right, vertical + 1, level + 1, map);
	}

}
