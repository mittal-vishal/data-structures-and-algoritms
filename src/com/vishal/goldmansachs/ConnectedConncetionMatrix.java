package com.vishal.goldmansachs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedConncetionMatrix {
	
	public static void main(String[] args) {
		int matrix[][] = {
				{1, 0, 0, 1},
				{0, 1, 1, 1},
				{1, 0, 0, 1},
		};
		List<List<Integer>> list = new ArrayList<>();
		for(int i =0; i < matrix.length; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i =0;i<matrix.length;i++) {
			for(int j = 0;j<matrix[i].length; j++) {
				list.get(i).add(j, matrix[i][j]);
			}
		}
		
		System.out.println(countConnections(list));
		
	}

	// Complete the countConnections function below.
		public static int countConnections(List<List<Integer>> matrix) {
			Map<String, Set<String>> map = new HashMap<>();
			int count = 0;
			for (int i = 0; i < matrix.size(); i++) {
				for (int j = 0; j < matrix.get(i).size(); j++) {
					if (matrix.get(i).get(j) == 1) {
						count = count + checkForNeighbours(map, matrix, i, j);
					}
				}
			}
			return count;
		}

		private static int checkForNeighbours(Map<String, Set<String>> map, List<List<Integer>> matrix, int i, int j) {
			int validI[] = { 0, 0, -1, 1, -1, -1, 1, 1 };
			int validJ[] = { -1, 1, 0, 0, -1, 1, -1, 1 };
			int count = 0;
			if (isValid(matrix, i, j) && matrix.get(i).get(j) == 1) {
				for (int k = 0; k < validI.length; k++) {
					if (isValid(matrix, i + validI[k], j + validJ[k])) {
						if (matrix.get(i + validI[k]).get(j + validJ[k]) == 1) {
							Set<String> testList = map.get(i + "|" + j);
							if (testList == null || !testList.contains(i + validI[k] + "|" + (j + validJ[k]))) {
								count++;
								if (map.containsKey(i + "|" + j)) {
									Set<String> list = map.get(i + "|" + j);
									list.add((i + validI[k]) + "|" + (j + validJ[k]));
									map.put(i + "|" + j, list);
								} else {
									Set<String> list = new HashSet<>();
									list.add((i + validI[k]) + "|" + (j + validJ[k]));
									map.put(i + "|" + j, list);
								}
								if (map.containsKey((i + validI[k]) + "|" + (j + validJ[k]))) {
									Set<String> list = map.get((i + validI[k]) + "|" + (j + validJ[k]));
									list.add(i + "|" + j);
									map.put((i + validI[k]) + "|" + (j + validJ[k]), list);
								} else {
									Set<String> list = new HashSet<>();
									list.add(i + "|" + j);
									map.put((i + validI[k]) + "|" + (j + validJ[k]), list);
								}
							}
						}
					}
				}
			}
			return count;
		}

		private static boolean isValid(List<List<Integer>> matrix, int i, int j) {
			if(i >= 0 && i < matrix.size() && j >= 0 && j < matrix.get(i).size()) {
				return true;
			}
			return false;
		}
	
}
