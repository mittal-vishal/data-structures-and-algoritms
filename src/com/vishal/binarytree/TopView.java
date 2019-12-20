package com.vishal.binarytree;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopView {
	
	private static Node rootNode = null;
	private static List<Integer> list = null;
	private static Map<Integer, List<Integer>> map = null;

	public static void main(String[] args) {
		rootNode = new Node(1);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(3));
		rootNode.getLeft().setLeft(new Node(34));
		rootNode.getLeft().setRight(new Node(4));
		
		find(rootNode);

		List<Entry<Integer, List<Integer>>> sortList = new LinkedList<>(map.entrySet());

		Comparator<Entry<Integer, List<Integer>>> customComparator = (Entry<Integer, List<Integer>> o1,
				Entry<Integer, List<Integer>> o2) -> o1.getKey().compareTo(o2.getKey());

		Collections.sort(sortList, customComparator);

		for (Entry<Integer, List<Integer>> entry : sortList) {
			System.out.print(entry.getValue().get(0) + " ");
		}
	}

	private static void find(Node root) {
		map = new HashMap<>();
		find(root, 0);
	}

	private static void find(Node root, int value) {
		if (root != null) {
			if (map.containsKey(value)) {
				list = map.get(value);
				list.add(root.getData());
				map.put(value, list);
			} else {
				list = new LinkedList<>();
				list.add(root.getData());
				map.put(value, list);
			}
			if (root.getLeft() != null) {
				find(root.getLeft(), value - 1);
			}
			if (root.getRight() != null) {
				find(root.getRight(), value + 1);
			}
		}
	}

}
