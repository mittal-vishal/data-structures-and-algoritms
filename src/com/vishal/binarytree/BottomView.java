package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class BottomView {

	static class DataNode{
		private int data;
		private int level;
		public DataNode(int data, int level) {
			this.data = data;
			this.level = level;
		}
	}
	
	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(1);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(3));
		rootNode.getLeft().setLeft(new Node(4));
		rootNode.getLeft().setRight(new Node(5));
		rootNode.getRight().setLeft(new Node(6));
		rootNode.getRight().setRight(new Node(7));
		rootNode.getLeft().getLeft().setLeft(new Node(8));
		
		bottomView(rootNode);
	}

	private static void bottomView(Node root) {
		Map<Integer, List<DataNode>> map = new TreeMap<>();
		
		bottomView(root, 0, 0, map);
		
		List<DataNode> list = null; int topData = -1;

		for (Entry<Integer, List<DataNode>> entry : map.entrySet()) {
			list = entry.getValue();
			int maxLevel = Integer.MIN_VALUE;
			for(DataNode dataNode : list) {
				if(dataNode.level > maxLevel) {
					maxLevel = dataNode.level;
					topData = dataNode.data;
				}
			}
			System.out.print(topData + " ");
		}
	}

	public static void bottomView(Node root, int value, int level, Map<Integer, List<DataNode>> map) {
        if (root != null) {
            if (map.containsKey(value)) {
                List<DataNode> list = map.get(value);
                list.add(new DataNode(root.data, level));
                map.put(value, list);
            } else {
            	List<DataNode> list = new LinkedList<>();
                list.add(new DataNode(root.data, level));
                map.put(value, list);
            }
            if (root.left != null) {
            	bottomView(root.left, value - 1, level + 1, map);
            }
            if (root.right != null) {
            	bottomView(root.right, value + 1, level + 1, map);
            }
        }
    }

}
