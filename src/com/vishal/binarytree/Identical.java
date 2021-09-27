package com.vishal.binarytree;

public class Identical {

	private static TreeNode rootNodeA = null;
	private static TreeNode rootNodeB = null;

	public static void main(String[] args) {
		rootNodeA = new TreeNode(1);
		rootNodeA.setLeft(new TreeNode(2));
		rootNodeA.setRight(new TreeNode(3));
		rootNodeA.getLeft().setLeft(new TreeNode(34));
		rootNodeA.getLeft().setRight(new TreeNode(4));
		rootNodeA.getRight().setLeft(new TreeNode(13));
		rootNodeA.getRight().setRight(new TreeNode(40));

		rootNodeB = new TreeNode(1);
		rootNodeB.setLeft(new TreeNode(2));
		rootNodeB.setRight(new TreeNode(3));
		rootNodeB.getLeft().setLeft(new TreeNode(34));
		rootNodeB.getLeft().setRight(new TreeNode(4));
		rootNodeB.getRight().setLeft(new TreeNode(13));
		rootNodeB.getRight().setRight(new TreeNode(40));

		System.out.println(find(rootNodeA, rootNodeB));
	}

	private static boolean find(TreeNode rootA, TreeNode rootB) {
		if (rootA == null || rootB == null) {
			return rootA == null && rootB == null;
		} else if(rootA.getData() == rootB.getData()){
			return true;
		}else{
			return find(rootA.getLeft(), rootB.getLeft())
					&& find(rootA.getRight(), rootB.getRight());
		}
	}

}
