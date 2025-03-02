package com.vishal.binarytree;

import java.util.HashSet;

public class LCAIII {

    static class Node{
        int val;
        Node left;
        Node right;
        Node parent;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        Node pParent = p;
        Node qParent = q;
        HashSet<Node> paths = new HashSet<>();
        while(pParent != null){
            paths.add(pParent);
            pParent = pParent.parent;
        }
        while(qParent != null){
            if(paths.contains(qParent)){
                return qParent;
            }else {
                qParent = qParent.parent;
            }
        }
        return null;
    }

}
