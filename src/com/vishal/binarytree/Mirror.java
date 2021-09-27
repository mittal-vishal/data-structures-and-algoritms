package com.vishal.binarytree;

public class Mirror {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(1);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(3));
		rootNode.getLeft().setLeft(new TreeNode(34));
		rootNode.getLeft().setRight(new TreeNode(4));
		PreOrder.find(rootNode);
		rootNode = invertTree(rootNode);
		System.out.println();
		PreOrder.find(rootNode);
	}

	public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
        if(left != null || right != null){
            root.left = right;
            root.right = left;
        }
        return root;
    }
	
}
