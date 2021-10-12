package com.vishal.binarytree;

public class PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence) {
        return findPath(root, sequence, 0);
    }

    private static boolean findPath(TreeNode root, int[] sequence, int currIdx){
        if(root == null || root.val != sequence[currIdx]){
            return false;
        }
        if(currIdx == sequence.length - 1 && root.val == sequence[currIdx]){
            return true;
        }

        boolean left = findPath(root.left, sequence, currIdx + 1);
        boolean right = findPath(root.right, sequence, currIdx + 1);
        return left || right;
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
