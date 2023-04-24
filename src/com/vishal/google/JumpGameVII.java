package com.vishal.google;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {

    class Pair{
        char ch;
        int index;
        Pair(char ch, int index){
            this.ch = ch;
            this.index = index;
        }
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair('0', 0));
        int min = -1;
        int max = -1;
        while(!queue.isEmpty()){
            Pair polled = queue.poll();
            if(polled.ch == '0' && polled.index == s.length()-1){
                return true;
            }
            min = Math.max(polled.index+minJump, max+1);
            max = Math.min(polled.index+maxJump, s.length()-1);
            for(int i = min; i <= max; i++){
                if(s.charAt(i) == '0'){
                    queue.offer(new Pair('0', i));
                }
            }
        }
        return false;
    }
}
