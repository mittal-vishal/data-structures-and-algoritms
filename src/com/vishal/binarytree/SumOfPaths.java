package com.vishal.binarytree;

public class SumOfPaths {

    public int sumNumbers(TreeNode root) {
        return getSumOfPaths(root, 0);
    }

    private int getSumOfPaths(TreeNode root, int pathSum){
        if(root == null){
            return 0;
        }
        pathSum = (10 * pathSum) + root.val;
        if(root.left == null && root.right == null){
            return pathSum;
        }
        int left = getSumOfPaths(root.left, pathSum);
        int right = getSumOfPaths(root.right, pathSum);
        return left + right;
    }

}
