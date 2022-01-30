package com.vishal.microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class EmptyPlots {

    public int solution(int K, int[][] A) {
        //Base case
        if(A == null || A.length == 0 || A[0].length == 0){
            return 0;
        }
        //target neighbours
        HashSet<String> targetSet = new HashSet<>();
        //Empty slots
        ArrayList<int[]> emptyPlots = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                //Add existing neighbours in target set
                //so that we can remove, lookup in constant time
                if(A[i][j] == 1){
                    targetSet.add(i + "," + j);
                }else{
                    //Add empty plots in list, to explore all
                    //possibilities as expected result
                    emptyPlots.add(new int[]{i, j});
                }
            }
        }
        //Initialize ans as 0, return at the end
        int closePlotsCount = 0;
        for(int[] emptyPlot: emptyPlots){
            boolean[][] visited = new boolean[A.length][A[0].length];
            //If matching the criteria, increment resultant ans
            if(bfs(A, emptyPlot, new HashSet(targetSet), K, visited)){
                closePlotsCount++;
            }
        }
        return closePlotsCount;
    }

    /*
    Use BFS traversal till unit distance reaches to K
    If all target are reached with given dist, then return true
    Else, return false
    */
    private boolean bfs(int[][] A, int[] plot, HashSet<String> targetSet, int K, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(plot);
        //All four possible directions L, R, U, B
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        //Initialize distance as 0
        int dist = 0;
        //While queue is not empty, keep exploring in breadth wise
        //while exploring if all target meet, return true, if we run out of
        //distance, then return false
        while(!queue.isEmpty()){
            //If current dist is exceeding the given criteria, return false
            if(dist > K){
                return false;
            }
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                //store current plot
                int[] currPlot = queue.poll();
                String currPlotKey = currPlot[0] + "," + currPlot[1];
                visited[currPlot[0]][currPlot[1]] = true;
                //If current plot is one of target, then decrement target size
                if(targetSet.contains(currPlotKey)){
                    targetSet.remove(currPlotKey);
                }
                //If all tagret are reached, then return true
                if(targetSet.isEmpty()){
                    return true;
                }
                //Otherwise keep exploring all neighbours
                for(int[] dir: dirs){
                    int newI = currPlot[0] + dir[0];
                    int newJ = currPlot[1] + dir[1];
                    //while exploring, if plot is valid and unique,
                    //then add in queue
                    if(isValid(newI, newJ, A) && !visited[newI][newJ]){
                        visited[newI][newJ] = true;
                        queue.offer(new int[]{newI, newJ});
                    }
                }
            }
            //After each breadth wise exploration, increment current distance
            dist++;
        }
        return false;
    }

    /*
    This will check validity for the given coordinates.
    Return true if inside grid, else false in case of out of bound
    */
    private boolean isValid(int i, int j, int[][]A){
        if(i >= 0 && i < A.length && j >= 0 && j < A[0].length){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int k = 2;
        int[][]A = {{0,0,0,0},{0,0,1,0},{1,0,0,1}};
        EmptyPlots emptyPlots = new EmptyPlots();
        int count = emptyPlots.solution(k, A);
        System.out.println(count);
    }

}
