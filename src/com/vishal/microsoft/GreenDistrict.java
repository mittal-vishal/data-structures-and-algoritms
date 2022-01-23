package com.vishal.microsoft;

import java.util.PriorityQueue;

public class GreenDistrict {

    private PriorityQueue<Integer> maxPq;
    private PriorityQueue<Integer> minPq;
    private int electricityPending;

    public static void main(String[] args) {
//        int[] electricity = {5, 3};
//        int X = 2;
//        int Y = 3;

//        int[] electricity = {5, 1};
//        int X = 1;
//        int Y = 3;

//        int[] electricity = {2,2,1,2,2};
//        int X = 2;
//        int Y = 3;

//        int[] electricity = {5,3,8,3,2};
//        int X = 2;
//        int Y = 5;

//        int[] electricity = {4,2,7};
//        int X = 4;
//        int Y = 100;

        int[] electricity = {4,1,5,3};
        int X = 5;
        int Y = 2;
        GreenDistrict district = new GreenDistrict();
        int minCost = district.getMinCost(electricity, X, Y);
        System.out.println(minCost);
    }

    /*
    * */
    private int getMinCost(int[] electricity, int X, int Y){
        int cost = 0;
        maxPq = new PriorityQueue<>((a,b) -> b - a);
        minPq = new PriorityQueue<>();
        //Adding all units in priority queue
        for(int unit: electricity){
            maxPq.offer(unit);
            minPq.offer(unit);
            electricityPending += unit;
        }
        while(!maxPq.isEmpty()){
            int currUnit = maxPq.peek();
            if(currUnit <= 0){
                break;
            }
            electricityPending -= currUnit;
            if(X >= Y || ((Y - X) < currUnit && electricityPending > (Y-X))){
                //Use type Y
                cost += Y;
                consumeElectricity(false);
            }else{
                //Use type X
                cost += X;
                consumeElectricity(true);
            }
        }
        return cost;
    }

    private void consumeElectricity(boolean isTypeX){
        if(isTypeX){
            int removeUnit = maxPq.poll();
            minPq.remove(removeUnit);
            electricityPending -= removeUnit;
        }else{
            int extraUnits = maxPq.poll();
            minPq.remove(extraUnits);
            while(extraUnits > 0 && !minPq.isEmpty()){
                int removeUnit = minPq.poll();
                maxPq.remove(removeUnit);
                if(extraUnits >= removeUnit){
                    extraUnits -= removeUnit;
                    electricityPending -= removeUnit;
                }else{
                    minPq.offer(removeUnit - extraUnits);
                    maxPq.offer(removeUnit - extraUnits);
                    break;
                }
            }
        }
    }

}
