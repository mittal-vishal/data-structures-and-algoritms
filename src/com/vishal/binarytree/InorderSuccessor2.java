package com.vishal.binarytree;

public class InorderSuccessor2 {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(1);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(3));
		rootNode.getLeft().setLeft(new TreeNode(4));
		rootNode.getLeft().setRight(new TreeNode(5));
		rootNode.getRight().setLeft(new TreeNode(6));
		rootNode.getRight().setRight(new TreeNode(7));
		int num = 1;
		TreeNode node = find(rootNode, num);
		if(node != null) {
			System.out.println(node.getVal());
		}else {
			System.out.println(-1);
		}
	}
	
	static class Next{
		boolean nextVal;
		TreeNode succ;
		public Next(boolean nextVal, TreeNode succ) {
			this.nextVal = nextVal;
			this.succ = succ;
		}
	}


	private static TreeNode find(TreeNode root, int num) {
		return find(root, num, new Next(false, null));
	}

	private static TreeNode find(TreeNode root, int num, Next next) {
		if(root == null)
			return null;
		else if(next.succ == null) {
			find(root.getLeft(), num, next);
			if(next.nextVal) {
				next.succ = root;
				next.nextVal = false;
			}
			if(root.getVal() == num)
				next.nextVal = true;
			find(root.getRight(), num, next);
			return next.succ;
		}else {
			return null;
		}
	}

}
