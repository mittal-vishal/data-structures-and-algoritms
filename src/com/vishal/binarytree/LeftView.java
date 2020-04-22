package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
	
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
		if(root != null) {
			Node item = null;
			queue.add(root);
			queue.add(null);
			System.out.print(root.getData() + " ");
			while(!queue.isEmpty()) {
				if(queue.peek() != null) {
					item = queue.poll();
					if(item.getLeft() != null)
						queue.add(item.getLeft());
					if(item.getRight() != null)
						queue.add(item.getRight());
				}else if(queue.peek() == null && queue.size() > 1) {
					queue.poll();
					System.out.print(queue.peek().getData() + " ");
					queue.add(null);
				}else {
					queue.poll();
				}
			}
		}
	}

}
