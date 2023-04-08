package com.vishal.binarysearchtree;

import com.vishal.binarytree.TreeNode;

public class ConstructBSTFromArrr {

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTree(nums, 0, nums.length-1);
    }

    private TreeNode constructTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = getMid(start, end);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums, start, mid-1);
        root.right = constructTree(nums, mid+1, end);
        return root;
    }

    private int getMid(int start, int end){
        int mid = -1;
        if(start <= end){
            mid = start + (end-start)/2;
        }
        return mid;
    }

}
