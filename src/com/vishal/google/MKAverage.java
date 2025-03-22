package com.vishal.google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MKAverage {

    private Deque<Integer> deque;
    private int m;
    private int k;
    private PriorityQueue<Integer> leftMaxElements;
    private PriorityQueue<Integer> rightMinElements;
    private TreeMap<Integer,Integer> middleElements;
    private int leftSum;
    private int totalSum;
    private int rightSum;

    public MKAverage(int m, int k) {
        this.deque = new ArrayDeque<>();
        this.m = m;
        this.k = k;
        leftMaxElements = new PriorityQueue<>((a,b) -> b-a);
        rightMinElements = new PriorityQueue<>((a,b) -> a-b);
        middleElements = new TreeMap<>();
    }

    public void addElement(int num) {
        deque.addLast(num);
        totalSum += num;
        if(deque.size() > m){
            int toBeDeleted = deque.removeFirst();
            delete(toBeDeleted);
            totalSum -= toBeDeleted;
        }
        insert(num);
    }

    public int calculateMKAverage() {
        if(deque.size() < m){
            return -1;
        }
        int averageNumerator = (totalSum - leftSum) - rightSum;
        int averageDenominator = m - (2*k);
        return averageNumerator/averageDenominator;
    }

    private void insert(int num){
        if(leftMaxElements.isEmpty() || num <= leftMaxElements.peek()){
            leftMaxElements.offer(num);
            leftSum += num;
        }else if(rightMinElements.isEmpty() || num >= rightMinElements.peek()){
            rightMinElements.offer(num);
            rightSum += num;
        }else{
            middleElements.put(num, middleElements.getOrDefault(num, 0) + 1);
        }
        balance();
    }

    private void delete(int num){
        //If contains in middle bucket
        if(middleElements.containsKey(num)){
            middleElements.put(num, middleElements.get(num) - 1);
            if(middleElements.get(num) == 0){
                middleElements.remove(num);
            }
        }else if(num <= leftMaxElements.peek()){
            leftMaxElements.remove(num);
            leftSum -= num;
            if(leftMaxElements.size() < k){
                int firstElement = middleElements.firstKey();
                middleElements.put(firstElement, middleElements.get(firstElement) - 1);
                if(middleElements.get(firstElement) == 0){
                    middleElements.remove(firstElement);
                }
                leftMaxElements.offer(firstElement);
                leftSum += firstElement;
            }
        }else{
            rightMinElements.remove(num);
            rightSum -= num;
            if(rightMinElements.size() < k){
                int lastElement = middleElements.lastKey();
                middleElements.put(lastElement, middleElements.get(lastElement) - 1);
                if(middleElements.get(lastElement) == 0){
                    middleElements.remove(lastElement);
                }
                rightMinElements.offer(lastElement);
                rightSum += lastElement;
            }
        }
    }

    private void balance(){
        //while left bucket size is more than k
        while(leftMaxElements.size() > k){
            int polledElement = leftMaxElements.poll();
            middleElements.put(polledElement, middleElements.getOrDefault(polledElement, 0) + 1);
            leftSum -= polledElement;
        }
        //while left bucket size is less than k, and middle has element
        while(leftMaxElements.size() < k && middleElements.size() > 0){
            int firstElement = middleElements.firstKey();
            middleElements.put(firstElement, middleElements.get(firstElement) - 1);
            if(middleElements.get(firstElement) == 0){
                middleElements.remove(firstElement);
            }
            leftMaxElements.offer(firstElement);
            leftSum += firstElement;
        }
        //If right bucket size is more than k
        while(rightMinElements.size() > k){
            int polledElement = rightMinElements.poll();
            middleElements.put(polledElement, middleElements.getOrDefault(polledElement, 0) + 1);
            rightSum -= polledElement;
        }
        //while left bucket size is less than k, and middle has element
        while(rightMinElements.size() < k && middleElements.size() > 0){
            int lastElement = middleElements.lastKey();
            middleElements.put(lastElement, middleElements.get(lastElement) - 1);
            if(middleElements.get(lastElement) == 0){
                middleElements.remove(lastElement);
            }
            rightMinElements.offer(lastElement);
            rightSum += lastElement;
        }
    }

    public static void main(String[] args) {
        MKAverage mkAverage = new MKAverage(3,1);
        mkAverage.addElement(3);
        mkAverage.addElement(1);
        System.out.println(mkAverage.calculateMKAverage());
        mkAverage.addElement(10);
        System.out.println(mkAverage.calculateMKAverage());
        mkAverage.addElement(5);
        mkAverage.addElement(5);
        mkAverage.addElement(5);
        System.out.println(mkAverage.calculateMKAverage());
    }

}
