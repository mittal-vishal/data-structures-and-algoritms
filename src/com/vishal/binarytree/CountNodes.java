package com.vishal.binarytree;

public class CountNodes {

    private int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return 1 + leftCount + rightCount;
    }

}
