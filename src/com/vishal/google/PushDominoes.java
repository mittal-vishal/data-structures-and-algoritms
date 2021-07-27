package com.vishal.google;

public class PushDominoes {

    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int force = 0;
        int[] forces = new int[n];
        for(int i = 0; i < n; i++){
            if(dominoes.charAt(i) == 'R'){
                force = n;
            }else if(dominoes.charAt(i) == 'L'){
                force = 0;
            }else{
                force = Math.max(0, force - 1);
            }
            forces[i] += force;
        }
        force = 0;
        for(int i = n-1; i >= 0; i--){
            if(dominoes.charAt(i) == 'L'){
                force = n;
            }else if(dominoes.charAt(i) == 'R'){
                force = 0;
            }else{
                force = Math.max(0, force - 1);
            }
            forces[i] -= force;
        }
        StringBuilder resultant = new StringBuilder();
        for(int i: forces){
            resultant.append(i > 0 ? 'R' : (i < 0) ? 'L' : '.');
        }
        return resultant.toString();
    }

}
