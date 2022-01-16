package com.vishal.google;

import java.util.*;

public class ConstructTree {

    static class TreeNode{
        int val;
        ArrayList<TreeNode> childs;
        public TreeNode(int val){
            this.val = val;
            childs = new ArrayList<>();
        }
    }

    public TreeNode constructTree(List<Map.Entry<Integer, Integer>> nodes){
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<Integer, Integer> degreeMap = new HashMap<>();
        constructTree(nodes, map, degreeMap);
        int max = Integer.MIN_VALUE;
        TreeNode root = null;
        for(Map.Entry<Integer,Integer> entry: degreeMap.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                root = map.get(entry.getKey());
            }
        }
        return root;
    }

    private void constructTree(List<Map.Entry<Integer, Integer>> nodes, HashMap<Integer, TreeNode> map, HashMap<Integer, Integer> degreeMap){
        for(Map.Entry<Integer, Integer> node: nodes){
            int parent = node.getKey();
            int child = node.getValue();
            TreeNode parentNode = null;
            TreeNode childNode = null;
            if(map.containsKey(node.getKey())){
                parentNode = map.get(parent);
            }else{
                parentNode = new TreeNode(parent);
            }
            if(map.containsKey(node.getValue())){
                childNode = map.get(child);
            }else{
                childNode = new TreeNode(child);
            }
            parentNode.childs.add(childNode);
            map.put(parentNode.val, parentNode);
            map.put(childNode.val, childNode);
            degreeMap.put(parent, degreeMap.getOrDefault(parent, 0) + 1);
            degreeMap.put(child, degreeMap.getOrDefault(child, 0) - 1);
        }
    }

    public static void main(String[] args) {
        List<Map.Entry<Integer, Integer>> nodes = new ArrayList<>();
        nodes.add(new AbstractMap.SimpleEntry<Integer, Integer>(80, 19));
        nodes.add(new AbstractMap.SimpleEntry<Integer, Integer>(50, 20));
        nodes.add(new AbstractMap.SimpleEntry<Integer, Integer>(20, 15));
        nodes.add(new AbstractMap.SimpleEntry<Integer, Integer>(80, 16));
        nodes.add(new AbstractMap.SimpleEntry<Integer, Integer>(50, 80));
        nodes.add(new AbstractMap.SimpleEntry<Integer, Integer>(20, 17));
        ConstructTree tree = new ConstructTree();
        TreeNode root = tree.constructTree(nodes);
    }

}