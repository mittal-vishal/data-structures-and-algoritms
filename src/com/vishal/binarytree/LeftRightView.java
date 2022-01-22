package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeftRightView {

    private static TreeNode root;

    public List<TreeNode> getLeftRightView(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<TreeNode> ans = new ArrayList<>();
        getLeftView(root, ans);
        getRightView(root.right, ans);
        return ans;
    }

    private void getLeftView(TreeNode root, List<TreeNode> ans){
        if(root == null){
            return;
        }
        getLeftView(root.left, ans);
        if(root.left == null){
            getLeftView(root.right, ans);
        }
        ans.add(root);
    }

    private void getRightView(TreeNode root, List<TreeNode> ans){
        if(root == null){
            return;
        }
        ans.add(root);
        getRightView(root.right, ans);
        if(root.right == null){
            getRightView(root.left, ans);
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.left = new TreeNode(8);
        LeftRightView leftRightView = new LeftRightView();
        List<TreeNode> view = leftRightView.getLeftRightView(root);
        view.stream().forEach( element -> System.out.print(element.val + " "));
    }

}
