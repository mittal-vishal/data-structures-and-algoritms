package com.vishal.cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
    class DoublyNode{
        int key;
        int data;
        DoublyNode prev;
        DoublyNode next;
        public DoublyNode(int key, int data){
            this.key = key;
            this.data = data;
        }
    }
    
    private Map<Integer, DoublyNode> map = null;
    private int size = -1;
    private int capacity = -1;
    private DoublyNode head = null;
    private DoublyNode tail = null; 

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        size = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DoublyNode node = map.get(key);
            if(node != tail){
                moveToTail(node);
            }
            return node.data;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        DoublyNode existedNode = map.get(key);
        if(existedNode == null){
            DoublyNode newNode = new DoublyNode(key, value);
            map.put(key, newNode);
            addNode(newNode);
            ++size;
            if(size > capacity){
                map.remove(head.key);
                removeNode(head);
                --size;
            }
        }else{
            existedNode.data = value;
            if(existedNode != tail){
                moveToTail(existedNode);
            }
        }
    }
    
    private void addNode(DoublyNode newNode){
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = null;
            tail = newNode;
        }
    }
    
    private void moveToTail(DoublyNode newNode) {
        removeNode(newNode);
        addNode(newNode);
    }

    private void removeNode(DoublyNode node) {
        if(node != head && node != tail){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }else if(node == head){
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }else if(node == tail){
            DoublyNode secondLastNode = tail.prev;
            secondLastNode.next = null;
            tail.prev = null;
            tail = secondLastNode;
        }
    }
}