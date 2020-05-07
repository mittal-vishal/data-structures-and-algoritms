package com.vishal.dynamicprogramming;

public class MinFuel {

	public static void main(String[] args) {
		int target = 100;
		int startF = 25;
		int stations[][] = { { 25, 25 }, { 50, 25 }, { 75, 25 } };
		System.out.println(minRefuelStops(target, startF, stations));
	}

	public static int minRefuelStops(int target, int startFuel, int[][] stations) {
		return minRefuelStops(target, startFuel, stations, 0) != Integer.MAX_VALUE
				? minRefuelStops(target, startFuel, stations, 0)
				: -1;
	}

	private static int minRefuelStops(int target, int startFuel, int[][] stations, int i) {
		if (target <= 0 || (startFuel >= target && target > 0)) {
			return 0;
		} else if (stations == null || stations.length == 0) {
			return Integer.MAX_VALUE;
		} else if (startFuel <= 0 && target > 0) {
			return Integer.MAX_VALUE;
		} else if (startFuel < target && i >= stations.length) {
			return Integer.MAX_VALUE;
		} else if (startFuel < stations[i][0]) {
			return Integer.MAX_VALUE;
		} else if (i < stations.length) {
			return Math.min(
					minRefuelStops(target - stations[i][0], startFuel - stations[i][0] + stations[i][1], stations,
							i + 1) == Integer.MAX_VALUE
									? minRefuelStops(target - stations[i][0],
											startFuel - stations[i][0] + stations[i][1], stations, i + 1)
									: minRefuelStops(target - stations[i][0],
											startFuel - stations[i][0] + stations[i][1], stations, i + 1) + 1,
					minRefuelStops(target - stations[i][0], startFuel - stations[i][0], stations, i + 1));
		}
		return -1;
	}

}
