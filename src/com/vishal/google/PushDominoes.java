package com.vishal.google;

public class PushDominoes {

    /*Using nearest moving dominoes*/
    public String pushDominoes1(String dominoes) {
        if(dominoes == null || dominoes.length() < 2){
            return dominoes;
        }

        int n = dominoes.length();

        int[] rightForcePos = new int[n];
        int[] leftForcePos = new int[n];

        int pos = -1;
        for(int i = 0; i < n; i++){
            if(dominoes.charAt(i) == 'R'){
                pos = i;
            }else if(dominoes.charAt(i) == 'L'){
                pos = -1;
            }
            rightForcePos[i] = pos;
        }

        pos = -1;
        for(int i = n-1; i >= 0; i--){
            if(dominoes.charAt(i) == 'L'){
                pos = i;
            }else if(dominoes.charAt(i) == 'R'){
                pos = -1;
            }
            leftForcePos[i] = pos;
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(dominoes.charAt(i) == '.' && (rightForcePos[i] != -1 || leftForcePos[i] != -1)){
                int rightPos = rightForcePos[i] == -1 ? Integer.MAX_VALUE: Math.abs(rightForcePos[i] - i);
                int leftPos = leftForcePos[i] == -1 ? Integer.MAX_VALUE: Math.abs(leftForcePos[i] - i);
                if(rightPos < leftPos){
                    result.append('R');
                }else if(leftPos < rightPos){
                    result.append('L');
                }else{
                    result.append('.');
                }
            }else{
                result.append(dominoes.charAt(i));
            }
        }
        return result.toString();
    }

    /* Using Resultant Force Concept*/
    public static String pushDominoes(String dominoes) {
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

    public static void main(String[] args) {
        String s = "R..L";
        System.out.print(pushDominoes(s));
    }

}
