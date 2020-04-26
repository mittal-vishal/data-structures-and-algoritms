package com.vishal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

	public class Node {
		private int i;
		private int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public int orangesRotting(int[][] grid) {
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Node(i, j));
				}
			}
		}
		return bfs(grid, queue);
	}

	private int bfs(int[][] grid, Queue<Node> queue) {
		int[] validI = { 0, 0, -1, 1 };
		int[] validJ = { -1, 1, 0, 0 };
		Node popped = null;
		int count = 0;
		boolean isChange = false;
		queue.add(null);
		while (!queue.isEmpty()) {
			popped = queue.poll();
			if(popped != null) {
				for (int k = 0; k < validI.length; k++) {
					if (isValid(popped.i + validI[k], popped.j + validJ[k], grid.length, grid[0].length)
							&& grid[popped.i + validI[k]][popped.j + validJ[k]] == 1) {
						grid[popped.i + validI[k]][popped.j + validJ[k]] = 2;
						isChange = true;
						queue.add(new Node(popped.i + validI[k], popped.j + validJ[k]));
					}
				}
			}else if(popped == null && isChange){
				isChange = false;
                if(!queue.isEmpty()){
                    queue.add(null);
                    count++;
                }
            }
		}
		List<Integer> finalList = new ArrayList<>();
		for(int[] a : grid) {
			for(Integer b : a) {
				finalList.add(b);
			}
		}
		if(finalList.parallelStream().allMatch(p -> p == 0)) {
			return 0;
		}else {
			return finalList.parallelStream().filter(p -> p == 1).count() == 0 ? count : -1;
		}
	}

	private boolean isValid(int i, int j, int m, int n) {
		if (i >= 0 && i < m && j >= 0 && j < n) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[][] grid = { {2}, {1}, {1}, {1}, {2}, {1}, {1} };
		System.out.println(new RottenOranges().orangesRotting(grid));

	}

}