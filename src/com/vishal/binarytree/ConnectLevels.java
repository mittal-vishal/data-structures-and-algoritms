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
        queue.offer(null);
        Node prev = null;
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr == null){
                prev = null;
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }else{
                if(prev != null){
                    prev.next = curr;
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            prev = curr;
        }
        return root;
    }

}
