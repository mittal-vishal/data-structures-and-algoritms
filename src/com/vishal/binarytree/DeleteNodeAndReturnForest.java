package com.vishal.binarytree;

import java.util.*;

public class DeleteNodeAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Map<TreeNode, TreeNode> nodeParentMap = new HashMap<>();
        Set<Integer> deleteNodeSet = new HashSet<>();
        for(int data: to_delete){
            deleteNodeSet.add(data);
        }
        List<TreeNode> forestList = new ArrayList<>();
        if(root == null){
            return forestList;
        }
        getForest(root, deleteNodeSet, forestList);
        if(!deleteNodeSet.contains(root.val)){
            forestList.add(root);
        }
        return forestList;
    }

    private TreeNode getForest(TreeNode root, Set<Integer> deleteNodeSet, List<TreeNode> forestList){
        if(root == null){
            return null;
        }
        root.left = getForest(root.left, deleteNodeSet, forestList);
        root.right = getForest(root.right, deleteNodeSet, forestList);
        if(deleteNodeSet.contains(root.val)){
            if(root.left != null){
                forestList.add(root.left);
            }
            if(root.right != null){
                forestList.add(root.right);
            }
            return null;
        }
        return root;
    }

    public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        Map<TreeNode, TreeNode> nodeParentMap = new HashMap<>();
        Set<Integer> deleteNodeSet = new HashSet<>();
        for(int data: to_delete){
            deleteNodeSet.add(data);
        }
        List<TreeNode> forestList = new ArrayList<>();
        if(root == null){
            return forestList;
        }
        getForest(root, deleteNodeSet, forestList);
        if(!deleteNodeSet.contains(root.val)){
            forestList.add(root);
        }else if(root != null && deleteNodeSet.contains(root.val)){
            updateForest(root, forestList);
        }
        return forestList;
    }

    private void updateForest(TreeNode root, List<TreeNode> forestList){
        if(root.left != null){
            forestList.add(root.left);
        }
        if(root.right != null){
            forestList.add(root.right);
        }
    }

    private TreeNode getForest2(TreeNode root, Set<Integer> deleteNodeSet, List<TreeNode> forestList){
        if(root == null){
            return null;
        }
        TreeNode left = getForest(root.left, deleteNodeSet, forestList);
        TreeNode right = getForest(root.right, deleteNodeSet, forestList);
        if(left != null && deleteNodeSet.contains(left.val)){
            updateForest(left, forestList);
            root.left = null;
        }
        if(right != null && deleteNodeSet.contains(right.val)){
            updateForest(right, forestList);
            root.right = null;
        }
        return root;
    }

}
