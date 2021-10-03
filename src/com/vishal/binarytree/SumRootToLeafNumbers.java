package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        dfs(root, pathList, "");
        int totalPathSum = 0;
        for(String pathSum: pathList){
            totalPathSum += Integer.valueOf(pathSum);
        }
        return totalPathSum;
    }

    private void dfs(TreeNode root, List<String> pathList, String pathSum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            pathSum += root.val;
            pathList.add(pathSum);
        }
        pathSum += root.val;
        dfs(root.left, pathList, pathSum);
        dfs(root.right, pathList, pathSum);
    }

}
