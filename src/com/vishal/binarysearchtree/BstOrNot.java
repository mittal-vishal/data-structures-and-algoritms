package com.vishal.binarysearchtree;

public class BstOrNot {

	private static TreeNode rootNode = null;
	
	static class Previous{
        private TreeNode prev;
    }

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.setLeft(new TreeNode(5));
		System.out.println(isValidBST(rootNode));
		System.out.println(findUsingRange(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	private static boolean isValidBST(TreeNode root) {
        return isValidBST(root, new Previous());
    }
    
    private static boolean isValidBST(TreeNode root, Previous previous){
        if(root != null){
            if(!isValidBST(root.getLeft(), previous))
                return false;
            if(previous.prev != null && root.getData() <= previous.prev.getData()){
                return false;
            }
            previous.prev = root;
            if(!isValidBST(root.getRight(), previous))
                return false;
        }
        return true;
    }

	private static boolean findUsingRange(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.getData() < min || root.getData() > max) {
			return false;
		}
		return (findUsingRange(root.getLeft(), min, root.getData())
				&& findUsingRange(root.getRight(), root.getData(), max));
	}

}
