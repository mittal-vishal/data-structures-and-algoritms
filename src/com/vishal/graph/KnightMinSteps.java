package com.vishal.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KnightMinSteps {

	public static void main(String[] args) {
		int n = 20;
		int[] knight = { 5, 7 };
		int[] target = { 15, 20 };
		System.out.println(minSteps(knight, target, n));
	}

	private static boolean isInside(int i, int j, int n) {
		if (i >= 0 && i < n && j >= 0 && j < n)
			return true;
		else
			return false;
	}

	private static int minSteps(int[] knight, int[] target, int n) {
		int[] possibleI = { -1, -2, -1, -2, 1, 2, 1, 2 };
		int[] possibleJ = { -2, -1, 2, 1, 2, 1, -2, -1 };
		Queue<Cell> queue = new LinkedList<Cell>();
		boolean[][] visited = new boolean[n][n];
		int dist[][] = new int[n][n];
		for(int distArray[] : dist) {
			Arrays.fill(distArray, -1);
		}
		dist[knight[0]-1][knight[1]-1] = 0;
		visited[knight[0]-1][knight[1]-1] = true;
		queue.add(new Cell(knight[0]-1, knight[1]-1));
		Cell cell = null;
		while (!queue.isEmpty()) {
			cell = queue.poll();
			for (int i = 0; i < possibleI.length; i++) {
				if (isInside(cell.getX() + possibleI[i], cell.getY() + possibleJ[i], n) && (!visited[cell.getX() + possibleI[i]][cell.getY() + possibleJ[i]])) {
					visited[cell.getX() + possibleI[i]][cell.getY() + possibleJ[i]] = true;
					dist[cell.getX() + possibleI[i]][cell.getY() + possibleJ[i]] = dist[cell.getX()][cell.getY()] + 1;
					queue.add(new Cell(cell.getX() + possibleI[i], cell.getY() + possibleJ[i]));
				}
			}
		}
		return dist[target[0]-1][target[1]-1];
	}

}
