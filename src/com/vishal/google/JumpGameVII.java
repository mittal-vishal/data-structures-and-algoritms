package com.vishal.google;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {

    public static class Element{
        char ch;
        int index;
        public Element(char ch, int index){
            this.ch = ch;
            this.index = index;
        }
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.length() == 0 || s.charAt(0) != '0'){
            return false;
        }

        Queue<Element> queue = new LinkedList<>();
        queue.offer(new Element(s.charAt(0), 0));
        int min = 0;
        int max = 0;

        while(!queue.isEmpty()){
            Element polled = queue.poll();
            if(polled.ch == '0' && polled.index == s.length() - 1){
                return true;
            }
            min = polled.index + minJump < max ? max + 1: polled.index + minJump;
            max = polled.index + maxJump;
            for(int i = min; i <= max; i++){
                if(i < s.length() && s.charAt(i) == '0'){
                    queue.offer(new Element(s.charAt(i), i));
                }
            }
        }

        return false;
    }
}
