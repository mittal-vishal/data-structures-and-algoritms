package com.vishal.binarytree;

public class Mirror {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(1);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(3));
		rootNode.getLeft().setLeft(new Node(34));
		rootNode.getLeft().setRight(new Node(4));
		PreOrder.find(rootNode);
		rootNode = invertTree(rootNode);
		System.out.println();
		PreOrder.find(rootNode);
	}

	public static Node invertTree(Node root) {
        if(root == null){
            return null;
        }
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);
        if(left != null || right != null){
            root.left = right;
            root.right = left;
        }
        return root;
    }
	
}
