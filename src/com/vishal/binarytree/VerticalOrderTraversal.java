package com.vishal.binarytree;

import java.util.*;

public class VerticalOrderTraversal {

    private TreeMap<Integer,TreeMap<Integer,List<Integer>>> verticalLevelNodes;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        verticalLevelNodes = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> results = new ArrayList<>();
        for(Map.Entry<Integer,TreeMap<Integer, List<Integer>>> entry: verticalLevelNodes.entrySet()){
            List<Integer> result = new ArrayList<>();
            TreeMap<Integer,List<Integer>> levelNodes = entry.getValue();
            for(Map.Entry<Integer,List<Integer>> levelNodesEntry: levelNodes.entrySet()){
                result.addAll(levelNodesEntry.getValue());
            }
            results.add(result);
        }
        return results;
    }

    private void dfs(TreeNode root, int vertical, int level){
        if(root == null){
            return;
        }
        verticalLevelNodes.putIfAbsent(vertical, new TreeMap<>());
        verticalLevelNodes.get(vertical).putIfAbsent(level, new ArrayList<>());
        verticalLevelNodes.get(vertical).get(level).add(root.val);
        dfs(root.left, vertical-1, level+1);
        dfs(root.right, vertical+1, level+1);
    }

}
