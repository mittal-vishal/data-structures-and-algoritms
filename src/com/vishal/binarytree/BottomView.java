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
		
		bottomView(rootNode);
	}

	private static void bottomView(TreeNode root) {
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

	public static void bottomView(TreeNode root, int value, int level, Map<Integer, List<DataNode>> map) {
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
            	bottomView(root.left, value - 1, level + 1, map);
            }
            if (root.right != null) {
            	bottomView(root.right, value + 1, level + 1, map);
            }
        }
    }

}
