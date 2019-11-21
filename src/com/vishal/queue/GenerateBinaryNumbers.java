package com.vishal.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

	public static void main(String[] args) {
		generate(2);
	}
	
	private static void generate(long n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for(int i = 0; i<n;i++) {
        	String item = queue.poll();
        	System.out.println(Integer.valueOf(item));
        	queue.add(item.concat("0"));
        	queue.add(item.concat("1"));
        }
    }

}
