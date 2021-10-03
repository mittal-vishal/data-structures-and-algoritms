package com.vishal.binarytree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

public class NodesAtKDistFromLeaf {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(15);
		rootNode.setLeft(new TreeNode(10));
		rootNode.setRight(new TreeNode(20));
		rootNode.getLeft().setLeft(new TreeNode(8));
		rootNode.getLeft().setRight(new TreeNode(12));
		rootNode.getRight().setLeft(new TreeNode(16));
		rootNode.getRight().setRight(new TreeNode(25));
		rootNode.getRight().getLeft().setRight(new TreeNode(18));
		find(rootNode, 1);
	}

	private static void find(TreeNode root, int k) {
		Set<Entry<Integer, TreeNode>> set = backTrack(root, k);
		for (Entry<Integer, TreeNode> entry : set) {
			if (entry.getKey() == k) {
				System.out.println(entry.getValue().getVal());
			}
		}
	}

	private static Set<Entry<Integer, TreeNode>> backTrack(TreeNode node, int k) {
		if (node == null) {
			return new HashSet<>();
		}
		Set<Entry<Integer, TreeNode>> leftT = backTrack(node.getLeft(), k);
		Set<Entry<Integer, TreeNode>> rightT = backTrack(node.getRight(), k);
		Iterator<Entry<Integer, TreeNode>> leftItr = leftT.iterator();
		Entry<Integer, TreeNode> entry = null;
		while (leftItr.hasNext()) {
			entry = leftItr.next();
			if (entry.getKey() == k) {
				System.out.println(entry.getValue().getVal());
			}
		}
		Iterator<Entry<Integer, TreeNode>> rightItr = rightT.iterator();
		while (rightItr.hasNext()) {
			entry = rightItr.next();
			if (entry.getKey() == k) {
				System.out.println(entry.getValue().getVal());
			}
		}
		if (leftT.isEmpty()) {
			leftT.add(new SimpleEntry<Integer, TreeNode>(0, node));
		} else {
			Iterator<Entry<Integer, TreeNode>> itr = leftT.iterator();
			leftT = new HashSet<>();
			while (itr.hasNext()) {
				leftT.add(new SimpleEntry<Integer, TreeNode>(itr.next().getKey() + 1, node));
			}
		}
		if (rightT.isEmpty()) {
			rightT.add(new SimpleEntry<Integer, TreeNode>(0, node));
		} else {
			Iterator<Entry<Integer, TreeNode>> itr = rightT.iterator();
			rightT = new HashSet<>();
			while (itr.hasNext()) {
				rightT.add(new SimpleEntry<Integer, TreeNode>(itr.next().getKey() + 1, node));
			}
		}
		for (Entry<Integer, TreeNode> entryRight : rightT) {
			leftT.add(new SimpleEntry<Integer, TreeNode>(entryRight.getKey(), entryRight.getValue()));
		}
		return leftT;
	}

}
