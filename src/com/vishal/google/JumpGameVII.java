package com.vishal.google;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {

    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> queue = new LinkedList<>();
        if(s.charAt(0) != '0'){
            return false;
        }
        queue.offer(0);
        int min = -1;
        int max = -1;
        while(!queue.isEmpty()){
            Integer currIdx = queue.poll();
            if(currIdx == s.length()-1 && s.charAt(currIdx) == '0'){
                return true;
            }
            min = Math.max(currIdx + minJump, max+1);
            max = Math.min(currIdx + maxJump, s.length()-1);
            for(int i = min; i <= max; i++){
                if(s.charAt(i) == '0'){
                    queue.offer(i);
                }
            }
        }
        return false;
    }
}
