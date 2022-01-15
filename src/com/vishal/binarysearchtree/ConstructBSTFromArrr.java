package com.vishal.binarysearchtree;

import com.vishal.binarytree.TreeNode;

public class ConstructBSTFromArrr {

    public com.vishal.binarytree.TreeNode sortedArrayToBST(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    private com.vishal.binarytree.TreeNode constructTree(int[] nums, int beg, int end){
        if(beg > end){
            return null;
        }
        int mid = beg + (end - beg)/2;
        com.vishal.binarytree.TreeNode curr = new TreeNode(nums[mid]);
        curr.left = constructTree(nums, beg, mid-1);
        curr.right = constructTree(nums, mid+1, end);
        return curr;
    }

}
