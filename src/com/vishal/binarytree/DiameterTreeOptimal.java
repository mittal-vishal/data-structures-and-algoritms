package com.vishal.binarytree;

public class DiameterTreeOptimal {

	private static TreeNode rootNode = null;
	
	static class Pair<T,V>{
		public T height;
		public V diameter;
	}
	
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
		System.out.println(diameterOfBinaryTree(rootNode).diameter);
	}
	
    private static Pair<Integer, Integer> diameterOfBinaryTree(TreeNode root){
        if(root == null){
            Pair<Integer, Integer> hdPair = new Pair<>();
            hdPair.diameter = 0;
            hdPair.height = 0;
            return hdPair;
        }else{
            Pair<Integer, Integer> left = diameterOfBinaryTree(root.getLeft());
            Pair<Integer, Integer> right = diameterOfBinaryTree(root.getRight());
            int option1 = left.height + right.height;
            int option2 = left.diameter;
            int option3 = right.diameter;
            Pair<Integer, Integer> hdPair = new Pair<>();
            hdPair.diameter = Math.max(option1, Math.max(option2, option3));
            hdPair.height = Math.max(left.height, right.height) + 1;
            return hdPair;
        }
    }
}
