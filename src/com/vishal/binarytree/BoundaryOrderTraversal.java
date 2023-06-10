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
        List<Integer> results = new ArrayList<>();
        results.add(root.val);
        if(root.left != null){
            getLeftView(root.left, results);
        }
        if(root.left != null || root.right != null){
            getBottomView(root, results);
        }
        if(root.right != null){
            getRightView(root.right, results);
        }
        return results;
    }

    private void getLeftView(TreeNode node, List<Integer> results){
        if(node == null || (node.left == null && node.right == null)){
            return;
        }
        results.add(node.val);
        if(node.left == null){
            getLeftView(node.right, results);
        }else{
            getLeftView(node.left, results);
        }
    }

    private void getRightView(TreeNode node, List<Integer> results){
        if(node == null || (node.left == null && node.right == null)){
            return;
        }
        if(node.right == null){
            getRightView(node.left, results);
        }else{
            getRightView(node.right, results);
        }
        results.add(node.val);
    }

    private void getBottomView(TreeNode node, List<Integer> results){
        if(node == null){
            return;
        }else if(node.left == null && node.right == null){
            results.add(node.val);
        }
        getBottomView(node.left, results);
        getBottomView(node.right, results);
    }
}
