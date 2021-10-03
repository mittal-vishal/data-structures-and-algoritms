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
        List<Integer> nodes = new ArrayList<>();
        if(root == null){
            return nodes;
        }
        nodes.add(root.val);
        getLeftBoundary(root.left, nodes);
        getLeaves(root.left, nodes);
        getLeaves(root.right, nodes);
        getRightBoundary(root.right, nodes);
        return nodes;
    }

    private void getLeftBoundary(TreeNode root, List<Integer> nodes){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        nodes.add(root.val);
        if(root.left != null){
            getLeftBoundary(root.left, nodes);
        }else{
            getLeftBoundary(root.right, nodes);
        }
    }

    private void getRightBoundary(TreeNode root, List<Integer> nodes){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        if(root.right != null){
            getRightBoundary(root.right, nodes);
        }else{
            getRightBoundary(root.left, nodes);
        }
        nodes.add(root.val);
    }

    private void getLeaves(TreeNode root, List<Integer> nodes){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            nodes.add(root.val);
        }
        getLeaves(root.left, nodes);
        getLeaves(root.right, nodes);
    }
}
