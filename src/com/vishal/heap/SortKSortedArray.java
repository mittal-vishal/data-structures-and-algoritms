package com.vishal.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {

	public static void main(String[] args) {
		int array[][] = { { 2, 4, 11 }, { 1, 7, 13 }, { 3, 6 } };
		System.out.println(sort(array));
	}

	private static List<Integer> sort(int[][] array) {
		List<Integer> resList = new ArrayList<>();
		Comparator<HeapStrucSort> comparator = (HeapStrucSort o1, HeapStrucSort o2) -> o1.getValue() - o2.getValue();
		PriorityQueue<HeapStrucSort> pq = new PriorityQueue<>(comparator);
		for (int i = 0; i < array.length; i++) {
			pq.add(new HeapStrucSort(array[i][0], i, 0));
		}
		HeapStrucSort heapobj = null;
		while (!pq.isEmpty()) {
			heapobj = pq.poll();
			resList.add(heapobj.getValue());
			if (array[heapobj.getArrayPos()].length > heapobj.getArrayIndex() + 1) {
				pq.add(new HeapStrucSort(array[heapobj.getArrayPos()][heapobj.getArrayIndex() + 1],
						heapobj.getArrayPos(), heapobj.getArrayIndex() + 1));
			}
		}
		return resList;
	}

}
