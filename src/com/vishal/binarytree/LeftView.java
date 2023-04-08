package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {
	
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
		LeftView leftView = new LeftView();
		List<Integer>leftViewList = leftView.leftView(rootNode);
		System.out.print(leftViewList);
	}

	ArrayList<Integer> leftView(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		levelorder(root, result);
		return result;
	}

	private void levelorder(TreeNode root, ArrayList<Integer> result){
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		boolean isFirst = true;
		while(!queue.isEmpty()){
			TreeNode polled = queue.poll();
			if(polled != null){
				if(isFirst){
					result.add(polled.val);
					isFirst = false;
				}
				if(polled.left != null){
					queue.offer(polled.left);
				}
				if(polled.right != null){
					queue.offer(polled.right);
				}
			}else{
				isFirst = true;
				if(queue.size() > 0){
					queue.offer(null);
				}
			}
		}
	}

}
