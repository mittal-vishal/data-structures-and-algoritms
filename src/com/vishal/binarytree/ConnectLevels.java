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
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        Node prev = null;
        while(!queue.isEmpty()){
            Node polled = queue.poll();
            if(polled != null){
                if(prev != null){
                    prev.next = polled;
                }
                if(polled.left != null){
                    queue.offer(polled.left);
                }
                if(polled.right != null){
                    queue.offer(polled.right);
                }
            }else{
                prev.next = null;
                if(queue.size() > 0){
                    queue.offer(null);
                }
            }
            prev = polled;
        }
        return root;
    }

}
