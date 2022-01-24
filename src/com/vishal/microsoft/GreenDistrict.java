package com.vishal.microsoft;

import java.util.PriorityQueue;

public class GreenDistrict {

    private PriorityQueue<Integer> maxPq;
    private PriorityQueue<Integer> minPq;
    private int electricityPending;

    public static void main(String[] args) {
        GreenDistrict district = new GreenDistrict();
        int[] electricity1 = {5, 3};
        int X1 = 2;
        int Y1 = 3;
        //res=3
        int minCost1 = district.getMinCost(electricity1, X1, Y1);
        System.out.println(minCost1);

        int[] electricity2 = {5, 1};
        int X2 = 1;
        int Y2 = 3;
        //res=2
        int minCost2 = district.getMinCost(electricity2, X2, Y2);
        System.out.println(minCost2);

        int[] electricity3 = {2,2,1,2,2};
        int X3 = 2;
        int Y3 = 3;
        //res = 8
        int minCost3 = district.getMinCost(electricity3, X3, Y3);
        System.out.println(minCost3);

        int[] electricity4 = {5,3,8,3,2};
        int X4 = 2;
        int Y4 = 5;
        //res=7
        int minCost4 = district.getMinCost(electricity4, X4, Y4);
        System.out.println(minCost4);

        int[] electricity5 = {4,2,7};
        int X5 = 4;
        int Y5 = 100;
        //res=12
        int minCost5 = district.getMinCost(electricity5, X5, Y5);
        System.out.println(minCost5);

        int[] electricity6 = {4,1,5,3};
        int X6 = 5;
        int Y6 = 2;
        //res = 4
        int minCost6 = district.getMinCost(electricity6, X6, Y6);
        System.out.println(minCost6);

        int[] electricity7 = {1,1,1};
        int X7 = 1;
        int Y7 = 2;
        //res = 3
        int minCost7 = district.getMinCost(electricity7, X7, Y7);
        System.out.println(minCost7);

        int[] electricity8 = {30,10,2,7};
        int X8 = 2;
        int Y8 = 10;
        //res = 3
        int minCost8 = district.getMinCost(electricity8, X8, Y8);
        System.out.println(minCost8);

    }

    /*
    * */
    private int getMinCost(int[] electricity, int X, int Y){
        int cost = 0;
        this.electricityPending = 0;
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
