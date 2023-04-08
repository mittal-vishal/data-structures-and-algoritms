package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;

public class MaxSumRootLeave {

private static TreeNode rootNode = null;
	
	public static void main(String args[]) { 
        rootNode = new TreeNode(1);
        rootNode.setLeft(new TreeNode(2));
        rootNode.setRight(new TreeNode(3));
        rootNode.getLeft().setLeft(new TreeNode(8));
        rootNode.getLeft().setRight(new TreeNode(4));
		rootNode.getLeft().getRight().setLeft(new TreeNode(10));
		rootNode.getRight().setLeft(new TreeNode(5));
		rootNode.getRight().setRight(new TreeNode(6));
		rootNode.getRight().getLeft().setLeft(new TreeNode(7));
		rootNode.getRight().getLeft().setRight(new TreeNode(9));
		rootNode.getRight().getRight().setRight(new TreeNode(5));
        System.out.println("maximum path sum is : " + maxPathSum(rootNode));
    }

	public static int maxPathSum(TreeNode root){
		List<Integer> results = new ArrayList<>();
		dfs(root, 0, results);
		int answer = Integer.MIN_VALUE;
		for(int sum: results){
			answer = Math.max(answer, sum);
		}
		return answer;
	}

	private static void dfs(TreeNode root, int num, List<Integer> results){
		if(root == null){
			return;
		}else if(root.left == null && root.right == null){
			num += root.val;
			results.add(num);
		}
		num += root.val;
		dfs(root.left, num, results);
		dfs(root.right, num, results);
	}
	
}
