package com.vishal.binarytree;

public class ConstructMaxBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int currMax = getMaxIndex(nums, start, end);
        TreeNode currNode = new TreeNode(nums[currMax]);
        currNode.left = constructTree(nums, start, currMax - 1);
        currNode.right = constructTree(nums, currMax + 1, end);
        return currNode;
    }

    private int getMaxIndex(int[] nums, int start, int end){
        int max = start;
        for(int i = start + 1; i <= end; i++){
            if(nums[i] > nums[max]){
                max = i;
            }
        }
        return max;
    }

}
