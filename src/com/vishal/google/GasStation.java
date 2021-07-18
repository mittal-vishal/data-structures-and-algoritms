package com.vishal.google;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int currPetrol = 0;
        int deficit = 0;
        int n = gas.length;
        int start = 0;

        for(int i = 0; i < n; i++){
            currPetrol += gas[i];
            currPetrol -= cost[i];
            if(currPetrol < 0){
                deficit += currPetrol;
                currPetrol = 0;
                start = i + 1;
            }
        }

        if(deficit + currPetrol >= 0){
            return start;
        }else{
            return -1;
        }
    }

    public static int canCompleteCircuitBruteForce(int[] gas, int[] cost) {
        int petrol = -1;
        int n = gas.length;
        for(int i = 0; i < n; i++){
            petrol = 0;
            for(int j = i; j < (n+i); j++){
                petrol += gas[j%n];
                petrol -= cost[j%n];
                if(petrol < 0){
                    break;
                }
                if(j == (n+i-1)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.print(canCompleteCircuit(gas, cost));
    }

}
