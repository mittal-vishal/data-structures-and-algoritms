package com.vishal.binarytree;

public class StrepByStepDirection {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = getLca(root, startValue, destValue);
        StringBuilder startValuePath = new StringBuilder();
        buildPath(ancestor, startValue, startValuePath);
        StringBuilder result =  new StringBuilder();
        for(int i = 0; i < startValuePath.length(); i++){
            result.append("U");
        }
        startValuePath.setLength(0);
        buildPath(ancestor, destValue, startValuePath);
        for(int i = 0; i < startValuePath.length(); i++){
            result.append(startValuePath.charAt(i));
        }
        return result.toString();
    }

    private boolean buildPath(TreeNode root, int val, StringBuilder sb){
        if(root == null){
            return false;
        }else if(root.val == val){
            return true;
        }else{
            sb.append("L");
            if(buildPath(root.left, val, sb)){
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("R");
            if(buildPath(root.right, val, sb)){
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
            return false;
        }
    }

    private TreeNode getLca(TreeNode root, int startValue, int destValue){
        if(root == null){
            return null;
        }else if(root.val == startValue || root.val == destValue){
            return root;
        }else{
            TreeNode leftTree = getLca(root.left, startValue, destValue);
            TreeNode rightTree = getLca(root.right, startValue, destValue);
            if(leftTree != null && rightTree != null){
                return root;
            }else{
                return leftTree != null? leftTree: rightTree;
            }
        }
    }

}
