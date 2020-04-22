package com.vishal.binarytree;

public class Identical {

	private static Node rootNodeA = null;
	private static Node rootNodeB = null;

	public static void main(String[] args) {
		rootNodeA = new Node(1);
		rootNodeA.setLeft(new Node(2));
		rootNodeA.setRight(new Node(3));
		rootNodeA.getLeft().setLeft(new Node(34));
		rootNodeA.getLeft().setRight(new Node(4));
		rootNodeA.getRight().setLeft(new Node(13));
		rootNodeA.getRight().setRight(new Node(40));

		rootNodeB = new Node(1);
		rootNodeB.setLeft(new Node(2));
		rootNodeB.setRight(new Node(3));
		rootNodeB.getLeft().setLeft(new Node(34));
		rootNodeB.getLeft().setRight(new Node(4));
		rootNodeB.getRight().setLeft(new Node(13));
		rootNodeB.getRight().setRight(new Node(40));

		System.out.println(find(rootNodeA, rootNodeB));
	}

	private static boolean find(Node rootA, Node rootB) {
		if (rootA == null || rootB == null) {
			return rootA == null && rootB == null;
		} else if(rootA.getData() == rootB.getData()){
			return true;
		}else{
			return find(rootA.getLeft(), rootB.getLeft())
					&& find(rootA.getRight(), rootB.getRight());
		}
	}

}
