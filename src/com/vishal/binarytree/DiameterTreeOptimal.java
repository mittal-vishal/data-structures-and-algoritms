package com.vishal.binarytree;

public class DiameterTreeOptimal {

	private static Node rootNode = null;
	
	static class Pair<T,V>{
		public T height;
		public V diameter;
	}
	
	public static void main(String[] args) {
		rootNode = new Node(1);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(3));
		rootNode.getLeft().setLeft(new Node(34));
		rootNode.getLeft().setRight(new Node(4));
		rootNode.getRight().setLeft(new Node(13));
		rootNode.getRight().setRight(new Node(40));
		rootNode.getLeft().getLeft().setLeft(new Node(10));
		rootNode.getLeft().getLeft().setRight(new Node(12));
		System.out.println(diameterOfBinaryTree(rootNode).diameter);
	}
	
    private static Pair<Integer, Integer> diameterOfBinaryTree(Node root){
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
