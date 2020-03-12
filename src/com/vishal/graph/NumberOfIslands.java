package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfIslands {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			List<List<Integer>> list = new ArrayList<>(N);
			for(int i =0;i<N;i++) {
				List<Integer> temp = new ArrayList<>();
				list.add(i, temp);
			}
			for(int i = 0;i<N;i++) {
				for(int j=0;j<M;j++) {
					int val = sc.nextInt();
					list.get(i).add(j, val);
				}
			}
			System.out.println(findIslands(list, N, M));
		}
		sc.close();
	}

	private static int findIslands(List<List<Integer>> list, int N, int M) {

        int[][] island = new int[N][M];
        for(int i=0; i<N;i++){
            for(int j = 0; j<M; j++){
                island[i][j] = list.get(i).get(j);
            }
        }
        return numIslands(island);
    }
    
    private static int numIslands(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        for(int i= 0; i< grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    count += dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private static int dfs(int[][]grid, int i, int j){
        if(i < 0 || i>=grid.length || j<0 || j>=grid[i].length){
            return 0;
        }
        if(grid[i][j] == 1){
            grid[i][j] = 0;
            dfs(grid, i+1,j);
            dfs(grid, i-1,j);
            dfs(grid, i,j-1);
            dfs(grid, i,j+1);
        }
        return 1;
    }

}
