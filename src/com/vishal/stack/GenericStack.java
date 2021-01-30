package com.vishal.stack;

public class GenericStack<T> {

    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top = null;

    public void push(T item){
        Node<T> temp = new Node<>(item);
        temp.next = top;
        top = temp;
    }

    public T pop(){
        if(top == null){
            return null;
        }else{
            Node<T> item = top;
            top = top.next;
            item.next = null;
            return item.data;
        }
    }

    public T peek(){
        if(top == null)
            return null;
        else
            return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void print(){
        Node<T> iterator = top;
        while(iterator != null){
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
    }

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        System.out.println(stack.peek());
        stack.push(4);
        stack.push(7);
        stack.print();
    }

}
