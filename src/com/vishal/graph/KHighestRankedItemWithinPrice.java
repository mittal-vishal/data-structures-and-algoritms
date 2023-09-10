package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KHighestRankedItemWithinPrice {

    public static void main(String[] args) {
        int[][] grid = {{2,0,2},{4,5,3},{2,0,2}};
        int[] price = {2,5};
        int[] start = {1,1};
        int k = 9;
        KHighestRankedItemWithinPrice kHighestRankedItemWithinPrice = new KHighestRankedItemWithinPrice();
        System.out.println(kHighestRankedItemWithinPrice.highestRankedKItems(grid, price, start, k));
    }

    /*
    *
    * {2,0,2},
    * {4,5,3},
    * {2,0,2}
    *
    * {0,2} {2,2} {0,0} {2,0}
    *
    * */

    static class Cell{
        int row;
        int col;
        int dist;
        int price;
        public Cell(int row, int col, int dist, int price){
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.price = price;
        }
    }
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> {
            if(a.dist != b.dist){
                return a.dist-b.dist;
            }else if(a.price != b.price){
                return a.price-b.price;
            }else if(a.row != b.row){
                return a.row-b.row;
            }else{
                return a.col-b.col;
            }
        });
        if(grid[start[0]][start[1]] == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        pq.offer(new Cell(start[0], start[1], 0, grid[start[0]][start[1]]));
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[start[0]][start[1]] = true;
        while(!pq.isEmpty()){
            Cell curr = pq.poll();
            if(isInPriceRange(pricing, curr.price) && curr.price != 1){
                result.add(new ArrayList<>(Arrays.asList(curr.row, curr.col)));
                if(result.size() == k){
                    return result;
                }
            }
            for(int[]dir: dirs){
                int newRow = curr.row+dir[0];
                int newCol = curr.col+dir[1];
                if(isValid(newRow, newCol, grid) && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    if(grid[newRow][newCol] != 0){
                        pq.offer(new Cell(newRow, newCol, curr.dist+1, grid[newRow][newCol]));
                    }
                }
            }
        }
        return result;
    }

    private boolean isInPriceRange(int[] pricing, int price){
        if(price >= pricing[0] && price <= pricing[1]){
            return true;
        }
        return false;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >=0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
