package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, paths, "");
        return paths;
    }

    private void dfs(TreeNode root, List<String> paths, String path){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            path += root.val;
            paths.add(path);
        }
        path += root.val;
        dfs(root.left, paths, path + "->");
        dfs(root.right, paths, path + "->");
    }

}
