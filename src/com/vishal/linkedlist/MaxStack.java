package com.vishal.linkedlist;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

class MaxStack {

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        int x = maxStack.popMax();
        System.out.println(x);
        x = maxStack.peekMax();
        System.out.println(x);
    }

    static class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val){
            this.val = val;
        }
    }

    private Stack<Integer> stack;
    private TreeMap<Integer, ArrayList<Node>> sortedValueNodes;
    private Node head;
    private Node tail;

    public MaxStack() {
        stack = new Stack<>();
        sortedValueNodes = new TreeMap<>((a,b) -> b-a);
        head = null;
        tail = null;
    }

    public void push(int x) {
        Node topNode = addToTail(x);
        sortedValueNodes.putIfAbsent(x, new ArrayList<>());
        sortedValueNodes.get(x).add(topNode);
    }

    public int pop() {
        Node topNode = removeFromTail();
        int val = topNode.val;
        ArrayList<Node> nodes = sortedValueNodes.get(val);
        nodes.remove(nodes.size()-1);
        if(nodes.size() == 0){
            sortedValueNodes.remove(val);
        }
        return val;
    }

    public int top() {
        if(tail != null){
            return tail.val;
        }else{
            return -1;
        }
    }

    public int peekMax() {
        if(sortedValueNodes.size() == 0){
            return -1;
        }
        int maxKey = sortedValueNodes.firstKey();
        return maxKey;
    }

    public int popMax() {
        if(sortedValueNodes.size() == 0){
            return -1;
        }
        int maxKey = sortedValueNodes.firstKey();
        ArrayList<Node> nodes = sortedValueNodes.get(maxKey);
        Node lastNode = nodes.remove(nodes.size()-1);
        if(nodes.size() == 0){
            sortedValueNodes.remove(maxKey);
        }
        remove(lastNode);
        return lastNode.val;
    }

    private Node removeFromTail(){
        Node temp = tail;
        remove(tail);
        return temp;
    }

    private void remove(Node node){
        if(head == tail && node == head){
            head = null;
            tail = null;
        }else if(node == head){
            node = node.next;
            head.next = null;
            node.prev = null;
            head = node;
        }else if(node != tail){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }else{
            node.prev.next = node.next;
            tail = node.prev;
        }
    }

    private Node addToTail(int x){
        Node newNode = new Node(x);
        if(tail == null){
            tail = newNode;
            head= tail;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
        return newNode;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
