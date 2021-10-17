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
		Identical identical = new Identical();
		boolean isSame = identical.isSameTree(rootNodeA, rootNodeB);
		System.out.print(isSame);
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null){
			return true;
		}else if(p == null || q == null){
			return false;
		}else if(p.val != q.val){
			return false;
		}else{
			boolean isLeftSame = isSameTree(p.left, q.left);
			boolean isRightSame = isSameTree(p.right, q.right);
			return isLeftSame && isRightSame;
		}
	}

}
