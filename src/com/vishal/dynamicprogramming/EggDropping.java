package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class EggDropping {
	
	public static void main(String[] args) {
		int n = 2;
		int k = 6; 
		System.out.println(superEggDrop(n, k));
	}

	public static int superEggDrop(int K, int N) {
        Map<String, Integer> lookUp = new HashMap<>();
        return superEggDrop(lookUp, K, N);
    }
    
    private static int superEggDrop(Map<String, Integer> lookUp, int K, int N){
        String key = K + "|" + N;
        if(K == 1){
            return N;
        }else if(N == 0 || N == 1){
            return N;
        }else if(lookUp.containsKey(key)){
            return lookUp.get(key);
        }else{
            int min = Integer.MAX_VALUE;
            int result = 0;
            for(int i = 1; i <= N; i++){
                result = 1 + Math.max(
                    superEggDrop(lookUp, K - 1, i - 1),
                    superEggDrop(lookUp, K, N - i)
                );
                if(result < min){
                    min = result;
                }
            }
            lookUp.put(key, min);
            return lookUp.get(key);
        }
    }

}
