package com.vishal.binarytree;

public class Subtree {

	public static boolean isSubtree(Node T, Node S) {
        if(T == null){
            return false;
        }else if(isSame(T, S)){
            return true;
        }else{
            boolean left = isSubtree(T.getLeft(), S);
            boolean right = isSubtree(T.getRight(), S);
            return left || right;
        }
    }
    
    private static boolean isSame(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null || root2 == null){
            return false;
        }else if(root1.getData() == root2.getData()){
            return isSame(root1.getLeft(), root2.getLeft()) &&
                   isSame(root1.getRight(), root2.getRight());
        }else{
            return false;
        }
    }
	
}
