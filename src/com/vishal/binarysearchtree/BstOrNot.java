package com.vishal.binarysearchtree;

import com.vishal.binarytree.Node;

public class BstOrNot {

	private static Node rootNode = null;
	
	static class Previous{
        private Node prev;
    }

	public static void main(String[] args) {
		rootNode = new Node(5);
		rootNode.setLeft(new Node(5));
		System.out.println(isValidBST(rootNode));
		System.out.println(findUsingRange(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	private static boolean isValidBST(Node root) {
        return isValidBST(root, new Previous());
    }
    
    private static boolean isValidBST(Node root, Previous previous){
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

	private static boolean findUsingRange(Node root, int min, int max) {
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
