package com.vishal.binarytree;

import java.util.*;

public class DeleteNodeAndReturnForest {

    private HashSet<Integer> deleteNodes;
    private List<TreeNode> result;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        result = new ArrayList<>();
        deleteNodes = new HashSet<>();
        for(int node: to_delete){
            deleteNodes.add(node);
        }
        dfs(root);
        if(!deleteNodes.contains(root.val)){
            result.add(root);
        }
        return result;
    }

    private TreeNode dfs(TreeNode root){
        if(root == null){
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if(deleteNodes.contains(root.val)){
            if(root.left != null){
                result.add(root.left);
            }
            if(root.right != null){
                result.add(root.right);
            }
            return null;
        }else{
            return root;
        }

    }

}
