package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevels {

    static class Node{
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node prev = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node curr = queue.poll();
                if(prev != null){
                    prev.next = curr;
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
                prev = curr;
            }
            prev = null;
        }
        return root;
    }

}
