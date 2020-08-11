package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLine {
	
	private static Node rootNode = null;

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
		find(rootNode);
	}

	private static void find(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		Node popped = null;
		while(!queue.isEmpty()) {
			popped = queue.poll();
			if(popped == null){
				System.out.println();
			    if(queue.size() > 0) {
			    	queue.add(null);
			    }
			}else{				
				System.out.print(popped.getData() + " ");
				if(popped.getLeft() != null) {
					queue.add(popped.getLeft());
				}
				if(popped.getRight() != null) {
					queue.add(popped.getRight());
				}
			}
		}
	}
	
}
