package com.vishal.binarytree;

public class InorderSuccessor2 {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(1);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(3));
		rootNode.getLeft().setLeft(new Node(4));
		rootNode.getLeft().setRight(new Node(5));
		rootNode.getRight().setLeft(new Node(6));
		rootNode.getRight().setRight(new Node(7));
		int num = 1;
		Node node = find(rootNode, num);
		if(node != null) {
			System.out.println(node.getData());
		}else {
			System.out.println(-1);
		}
	}
	
	static class Next{
		boolean nextVal;
		Node succ;
		public Next(boolean nextVal, Node succ) {
			this.nextVal = nextVal;
			this.succ = succ;
		}
	}


	private static Node find(Node root, int num) {
		return find(root, num, new Next(false, null));
	}

	private static Node find(Node root, int num, Next next) {
		if(root == null)
			return null;
		else if(next.succ == null) {
			find(root.getLeft(), num, next);
			if(next.nextVal) {
				next.succ = root;
				next.nextVal = false;
			}
			if(root.getData() == num)
				next.nextVal = true;
			find(root.getRight(), num, next);
			return next.succ;
		}else {
			return null;
		}
	}

}
