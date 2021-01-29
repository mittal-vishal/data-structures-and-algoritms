package com.vishal.queue;

public class GenericQueue<T> {

    private Node<T> front = null;
    private Node<T> rear = null;

    public static void main(String[] args) {
        GenericQueue queue = new GenericQueue();
        queue.enqueue(1);
        queue.enqueue(7);
        queue.dequeue();
        queue.print();
    }

    public void enqueue(T item) {
        Node<T> temp = new Node<>(item);
        if (front == null) {
            front = temp;
            rear = front;
        } else {
            rear.next = temp;
            rear = temp;
        }
    }

    public T dequeue() {
        if (front == null) {
            return null;
        } else {
            Node<T> item = front;
            front = front.next;
            item.next = null;
            return item.data;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public T peek() {
        if (front == null) {
            return null;
        } else {
            return front.data;
        }
    }

    public void print() {
        Node<T> iterator = front;
        while (iterator != null) {
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
    }

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

}
