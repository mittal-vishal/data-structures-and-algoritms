package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralLevelTraversal {
	
	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(5);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(25));
		rootNode.getLeft().setLeft(new Node(1));
		rootNode.getLeft().setRight(new Node(4));
		rootNode.getRight().setLeft(new Node(13));
		rootNode.getRight().setRight(new Node(40));
		rootNode.getLeft().getLeft().setLeft(new Node(10));
		rootNode.getLeft().getLeft().setRight(new Node(12));
		find(rootNode);
	}

	private static void find(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<>();
		queue.add(root);
		queue.add(null);
		int level = 1;
		while(!queue.isEmpty()) {
			if(queue.size() == 1 && queue.peek() == null) {
				break;
			}
			if(level % 2 == 1) {
				if(queue.peek() != null) {
					Node item = queue.poll();
					stack.push(item);
					if(item.getLeft() != null) {
						queue.add(item.getLeft());
					}
					if(item.getRight() != null) {
						queue.add(item.getRight());
					}
				}else {
					queue.poll();
					queue.add(null);
					while(!stack.isEmpty()) {
						System.out.print(stack.pop().getData() + " ");
					}
					System.out.println();
					level++;
				}
			}else {
				if(queue.peek() != null) {
					Node item = queue.poll();
					System.out.print(item.getData() + " ");
					if(item.getLeft() != null) {
						queue.add(item.getLeft());
					}
					if(item.getRight() != null) {
						queue.add(item.getRight());
					}
				}else {
					queue.poll();
					queue.add(null);
					System.out.println();
					level++;
				}
			}
		}
	}

}
