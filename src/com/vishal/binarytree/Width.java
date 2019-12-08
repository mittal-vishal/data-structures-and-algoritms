package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Width {
	
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
		System.out.println(find(rootNode));
	}

	private static int find(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		Node item = null;
		int size = -1;
		while(!queue.isEmpty()) {
		    if(queue.peek() == null && queue.size() == 1){
		        break;
		    }
			if(queue.peek() == null){
			    queue.poll();
			    if(queue.size() > size) {
			    	size = queue.size();
			    }
			    queue.add(null);
			}
			item = queue.poll();
			if(item.getLeft() != null) {
				queue.add(item.getLeft());
			}
			if(item.getRight() != null) {
				queue.add(item.getRight());
			}
		}
		return size;
	}
	
}
