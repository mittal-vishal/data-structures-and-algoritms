package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOrderTraversal {

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        rootNode.setLeft(new TreeNode(2));
        rootNode.setRight(new TreeNode(3));
        rootNode.getLeft().setLeft(new TreeNode(4));
        rootNode.getLeft().setRight(new TreeNode(5));
        rootNode.getRight().setLeft(new TreeNode(7));
        rootNode.getRight().setRight(new TreeNode(8));
        rootNode.getLeft().getRight().setLeft(new TreeNode(6));
        rootNode.getLeft().getRight().getLeft().setRight(new TreeNode(10));
        rootNode.getRight().getRight().setRight(new TreeNode(9));
        BoundaryOrderTraversal boundary = new BoundaryOrderTraversal();
        List<Integer>leftViewList = boundary.boundaryOfBinaryTree(rootNode);
        System.out.print(leftViewList);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundaryList = new ArrayList<>();
        boundaryList.add(root.val);
        leftTraversal(root.left, boundaryList);
        if(root.left != null || root.right != null){
            bottomTraversal(root, boundaryList);
        }
        rightTraversal(root.right, boundaryList);
        return boundaryList;
    }

    private void leftTraversal(TreeNode root, List<Integer> boundaryList){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        boundaryList.add(root.val);
        if(root.left != null){
            leftTraversal(root.left, boundaryList);
        }else{
            leftTraversal(root.right, boundaryList);
        }
    }

    private void rightTraversal(TreeNode root, List<Integer> boundaryList){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        if(root.right != null){
            rightTraversal(root.right, boundaryList);
        }else{
            rightTraversal(root.left, boundaryList);
        }
        boundaryList.add(root.val);
    }

    private void bottomTraversal(TreeNode root, List<Integer> boundaryList){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            boundaryList.add(root.val);
        }
        bottomTraversal(root.left, boundaryList);
        bottomTraversal(root.right, boundaryList);
    }
}
