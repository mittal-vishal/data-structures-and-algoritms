package com.vishal.binarytree;

import java.util.List;

public class NaryNode {

    public int val;
    public List<NaryNode> children;

    public NaryNode() {}

    public NaryNode(int _val) {
        val = _val;
    }

    public NaryNode(int _val, List<NaryNode> _children) {
        val = _val;
        children = _children;
    }

}
