package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TopView {
	
	static class DataNode{
		private int data;
		private int level;
		public DataNode(int data, int level) {
			this.data = data;
			this.level = level;
		}
	}
	
	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(1);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(3));
		rootNode.getLeft().setLeft(new TreeNode(4));
		rootNode.getLeft().setRight(new TreeNode(5));
		rootNode.getRight().setLeft(new TreeNode(6));
		rootNode.getRight().setRight(new TreeNode(7));
		rootNode.getLeft().getLeft().setLeft(new TreeNode(8));
		
		topView(rootNode);
	}

	private static void topView(TreeNode root) {
		Map<Integer, List<DataNode>> map = new TreeMap<>();
		
		topView(root, 0, 0, map);
		
		List<DataNode> list = null; int topData = -1;

		for (Entry<Integer, List<DataNode>> entry : map.entrySet()) {
			list = entry.getValue();
			int minLevel = Integer.MAX_VALUE;
			for(DataNode dataNode : list) {
				if(dataNode.level < minLevel) {
					minLevel = dataNode.level;
					topData = dataNode.data;
				}
			}
			System.out.print(topData + " ");
		}
	}

	public static void topView(TreeNode root, int value, int level, Map<Integer, List<DataNode>> map) {
        if (root != null) {
            if (map.containsKey(value)) {
                List<DataNode> list = map.get(value);
                list.add(new DataNode(root.val, level));
                map.put(value, list);
            } else {
            	List<DataNode> list = new LinkedList<>();
                list.add(new DataNode(root.val, level));
                map.put(value, list);
            }
            if (root.left != null) {
                topView(root.left, value - 1, level + 1, map);
            }
            if (root.right != null) {
                topView(root.right, value + 1, level + 1, map);
            }
        }
    }

}
