package com.vishal.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        HashMap<Node,Node> visited = new HashMap<>();
        dfs(node, visited);
        return visited.get(node);
    }

    private void dfs(Node node, HashMap<Node,Node> visited){
        if(node == null || visited.containsKey(node)){
            return;
        }
        Node clonedNode = new Node(node.val, new ArrayList<>());
        visited.put(node, clonedNode);
        for(Node neighbour: node.neighbors){
            dfs(neighbour, visited);
            Node neighbourNode = visited.get(neighbour);
            clonedNode.neighbors.add(neighbourNode);
        }
    }

}
