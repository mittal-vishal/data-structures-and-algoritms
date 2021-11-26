package com.vishal.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    private Queue<Integer> queue;
    private int size;
    private ReentrantLock lock;
    private Condition produce;
    private Condition consume;
    private static final int CAPACITY = 5;

    public ProducerConsumer(){
        queue = new LinkedList<>();
        size = 0;
        lock = new ReentrantLock();
        produce = lock.newCondition();
        consume = lock.newCondition();
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
    }

    private void produce(int item) {
        try {
            lock.lock();
            if (size == CAPACITY) {
                consume.await();
            }
            addItem(item);
            produce.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void consume(){
        try{
            lock.lock();
            if(size == 0){
                produce.await();
            }
            consumeItem();
            consume.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private void addItem(int item) {
        queue.offer(item);
        size++;
    }

    private void consumeItem() {
        size--;
        queue.poll();
    }


}
