package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOrderTraversal {

    public void addLeaves(List<Integer> res, Node root) {
        if(root != null) {
        	if (root.left == null && root.right == null) {
                res.add(root.data);
            } 
        	addLeaves(res, root.left);
        	addLeaves(res, root.right);
        }
    }

    public List<Integer> boundaryOfBinaryTree(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left != null && root.right != null) {
            res.add(root.data);
        }
        Node t = root.left;
        while (t != null) {
            if (t.left != null && t.right != null) {
                res.add(t.data);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }

        }
        addLeaves(res, root);
        Stack<Integer> s = new Stack<>();
        t = root.right;
        while (t != null) {
            if (t.left != null && t.right != null) {
                s.push(t.data);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }
	
}
