package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;

public class ShortestBridge {

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int shortestBridge(int[][] A) {
        List<Point> bridgeAList = new ArrayList<>();
        List<Point> bridgeBList = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 1){
                    count++;
                    if(count == 1){
                        floodFill(A, i, j, bridgeAList);
                    }else if(count == 2){
                        floodFill(A, i, j, bridgeBList);
                    }
                }
            }
        }
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < bridgeAList.size(); i++){
            for(int j = 0; j < bridgeBList.size(); j++){
                int currDist = Math.abs(bridgeAList.get(i).x - bridgeBList.get(j).x) +
                        Math.abs(bridgeAList.get(i).y - bridgeBList.get(j).y) - 1;
                minDist = Math.min(minDist, currDist);
            }
        }
        return minDist;
    }

    private void floodFill(int[][] A, int i, int j, List<Point> list){
        if(!isValid(i, j, A) || A[i][j] == 0){
            return;
        }
        list.add(new Point(i, j));
        A[i][j] = 0;
        floodFill(A, i-1, j, list);
        floodFill(A, i+1, j, list);
        floodFill(A, i, j-1, list);
        floodFill(A, i, j+1, list);
    }

    private boolean isValid(int i, int j, int[][] A){
        if(i >= 0 && i < A.length && j >= 0 && j < A[0].length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] bridge = {{0,1},{1,0}};
        ShortestBridge shortestBridge = new ShortestBridge();
        int minDist = shortestBridge.shortestBridge(bridge);
        System.out.println(minDist);
    }

}
