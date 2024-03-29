package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
	
	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(1);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(3));
		rootNode.getLeft().setLeft(new TreeNode(34));
		rootNode.getLeft().setRight(new TreeNode(4));
		rootNode.getRight().setLeft(new TreeNode(13));
		rootNode.getRight().setRight(new TreeNode(40));
		rootNode.getLeft().getLeft().setLeft(new TreeNode(10));
		rootNode.getLeft().getLeft().setRight(new TreeNode(12));
		LevelOrder levelOrder = new LevelOrder();
		levelOrder.levelOrder(rootNode);
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null){
			return new ArrayList<>();
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> levels = new ArrayList<>();
		while(!queue.isEmpty()){
			TreeNode polled = queue.poll();
			if(polled != null){
				levels.add(polled.val);
				if(polled.left != null){
					queue.offer(polled.left);
				}
				if(polled.right != null){
					queue.offer(polled.right);
				}
			}else{
				results.add(levels);
				if(queue.size() > 0){
					levels = new ArrayList<>();
					queue.offer(null);
				}
			}
		}
		return results;
	}
	
}
