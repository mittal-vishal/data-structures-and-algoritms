package com.vishal.binarytree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

public class NodesAtKDistFromLeaf {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(15);
		rootNode.setLeft(new Node(10));
		rootNode.setRight(new Node(20));
		rootNode.getLeft().setLeft(new Node(8));
		rootNode.getLeft().setRight(new Node(12));
		rootNode.getRight().setLeft(new Node(16));
		rootNode.getRight().setRight(new Node(25));
		rootNode.getRight().getLeft().setRight(new Node(18));
		find(rootNode, 1);
	}

	private static void find(Node root, int k) {
		Set<Entry<Integer, Node>> set = backTrack(root, k);
		for (Entry<Integer, Node> entry : set) {
			if (entry.getKey() == k) {
				System.out.println(entry.getValue().getData());
			}
		}
	}

	private static Set<Entry<Integer, Node>> backTrack(Node node, int k) {
		if (node == null) {
			return new HashSet<>();
		}
		Set<Entry<Integer, Node>> leftT = backTrack(node.getLeft(), k);
		Set<Entry<Integer, Node>> rightT = backTrack(node.getRight(), k);
		Iterator<Entry<Integer, Node>> leftItr = leftT.iterator();
		Entry<Integer, Node> entry = null;
		while (leftItr.hasNext()) {
			entry = leftItr.next();
			if (entry.getKey() == k) {
				System.out.println(entry.getValue().getData());
			}
		}
		Iterator<Entry<Integer, Node>> rightItr = rightT.iterator();
		while (rightItr.hasNext()) {
			entry = rightItr.next();
			if (entry.getKey() == k) {
				System.out.println(entry.getValue().getData());
			}
		}
		if (leftT.isEmpty()) {
			leftT.add(new SimpleEntry<Integer, Node>(0, node));
		} else {
			Iterator<Entry<Integer, Node>> itr = leftT.iterator();
			leftT = new HashSet<>();
			while (itr.hasNext()) {
				leftT.add(new SimpleEntry<Integer, Node>(itr.next().getKey() + 1, node));
			}
		}
		if (rightT.isEmpty()) {
			rightT.add(new SimpleEntry<Integer, Node>(0, node));
		} else {
			Iterator<Entry<Integer, Node>> itr = rightT.iterator();
			rightT = new HashSet<>();
			while (itr.hasNext()) {
				rightT.add(new SimpleEntry<Integer, Node>(itr.next().getKey() + 1, node));
			}
		}
		for (Entry<Integer, Node> entryRight : rightT) {
			leftT.add(new SimpleEntry<Integer, Node>(entryRight.getKey(), entryRight.getValue()));
		}
		return leftT;
	}

}
