package com.vishal.binarysearchtree;

public class MinElementBST {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(7);
		rootNode.setLeft(new Node(5));
		rootNode.setRight(new Node(10));
		rootNode.getLeft().setLeft(new Node(3));
		rootNode.getLeft().setRight(new Node(6));
		rootNode.getRight().setLeft(new Node(8));
		rootNode.getRight().setRight(new Node(12));
		System.out.println(find(rootNode));
	}
	
	private static int find(Node node) {
        while(node.getLeft() != null){
            node = node.getLeft();
        }
        return node.getData();
    }
	
}
