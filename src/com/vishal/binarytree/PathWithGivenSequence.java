package com.vishal.binarytree;

public class PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence) {
        return dfs(root, sequence, 0);
    }

    private static boolean dfs(TreeNode root, int[] sequence, int index){
        if(index == sequence.length){
            return true;
        }else if(root == null || root.val != sequence[index]){
            return false;
        }
        boolean inLeft = dfs(root.left, sequence, index+1);
        boolean inRight = dfs(root.right, sequence, index+1);
        return inLeft || inRight;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }

}
