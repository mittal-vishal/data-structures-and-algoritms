package com.vishal.binarytree;

public class Node {
	
	public int data;
	public Node left;
	public Node right;
	
	public Node(int item) {
		data = item;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
