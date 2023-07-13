package com.vishal.binarytree;

public class HeightOfBinaryTreeAfterSubtreeRemoval {

    public static void main(String[] args) {
        HeightOfBinaryTreeAfterSubtreeRemoval subtreeRemoval = new HeightOfBinaryTreeAfterSubtreeRemoval();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        int[] queries = {8};
        int[] res = subtreeRemoval.treeQueries(root, queries);
        System.out.println(res[0]);
    }

    private int[] allLevel;
    private int leftMaxLevel;
    private int rightMaxLevel;

    public int[] treeQueries(TreeNode root, int[] queries) {
        allLevel = new int[100001];
        dfsLeft(root, 0);
        dfsRight(root, 0);
        int k = queries.length;
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = allLevel[queries[i]];
        }
        return result;
    }

    private void dfsLeft(TreeNode root, int level){
        if(root == null){
            return;
        }
        allLevel[root.val] = leftMaxLevel;
        leftMaxLevel = Math.max(leftMaxLevel, level);
        dfsLeft(root.left, level+1);
        dfsLeft(root.right, level+1);
    }

    private void dfsRight(TreeNode root, int level){
        if(root == null){
            return;
        }
        allLevel[root.val] = Math.max(rightMaxLevel, allLevel[root.val]);
        rightMaxLevel = Math.max(rightMaxLevel, level);
        dfsRight(root.right, level+1);
        dfsRight(root.left, level+1);
    }

}
