package com.vishal.cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer,Node> cache;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            if(node != tail){
                moveToTail(node);
            }
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        Node existingNode = cache.get(key);
        //new data need to be inserted
        if(existingNode == null){
            Node newNode = new Node(key,value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
            if(size > capacity){
                cache.remove(head.key);
                removeNode(head);
                size--;
            }
        }else{
            //existing data need to be updated
            existingNode.value = value;
            if(existingNode != tail){
                moveToTail(existingNode);
            }
        }
    }

    private void addNode(Node node){
        if(tail != null){
            tail.next = node;
            node.prev = tail;
            tail = node;
        }else{
            tail = node;
            head = tail;
        }
    }

    private void removeNode(Node node){
        if(node == head){
            head = head.next;
            head.prev = null;
        }else if(node != tail && node != head){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }else if(node == tail){
            Node secondLast = tail.prev;
            secondLast.next = null;
            tail.prev = null;
            tail = secondLast;
        }
    }

    private void moveToTail(Node node){
        removeNode(node);
        addNode(node);
    }
}