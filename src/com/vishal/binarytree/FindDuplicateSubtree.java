package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtree {

    private HashMap<String,Integer> subtreeOccurance;
    private List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subtreeOccurance = new HashMap<>();
        result = new ArrayList<>();
        dfs(root);
        return result;
    }

    private String dfs(TreeNode root){
        if(root == null){
            return "#";
        }
        String left = dfs(root.left);
        String right = dfs(root.right);
        String path = root.val + "l" + left + "r" + right;
        subtreeOccurance.put(path, subtreeOccurance.getOrDefault(path, 0) + 1);
        if(subtreeOccurance.get(path) == 2){
            result.add(root);
        }
        return path;
    }

}
