package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathSumList = new ArrayList<>();
        dfs(root, pathSumList, targetSum, new ArrayList<>());
        return pathSumList;
    }

    private void dfs(TreeNode root, List<List<Integer>> pathSumList, int targetSum, List<Integer> pathList){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && targetSum == root.val){
            pathList.add(root.val);
            pathSumList.add(new ArrayList<>(pathList));
        }else{
            pathList.add(root.val);
        }
        dfs(root.left, pathSumList, targetSum - root.val, pathList);
        dfs(root.right, pathSumList, targetSum - root.val, pathList);
        pathList.remove(pathList.size()-1);
    }

}
