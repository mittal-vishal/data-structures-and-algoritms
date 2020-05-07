package com.vishal.arrays;

public class StockBuySell {

	public static void main(String[] args) {
		int a[] = { 23, 13, 25, 29, 33, 19, 34, 45, 65, 67 };
		stockBuySell(a, a.length);
	}

	private static void stockBuySell(int price[], int n) {
		int minima[] = new int[price.length];
		int maxima[] = new int[price.length];
		Integer max = Integer.MIN_VALUE;
		Integer min = Integer.MAX_VALUE;
		for (int i = price.length - 1; i >= 0; i--) {
			if (price[i] < max && price[i] < price[i + 1]) {
				maxima[i] = max;
			} else if (i == price.length - 1 || (price[i] > max && price[i] > price[i + 1])
					|| (price[i] < max && price[i] > price[i + 1])) {
				max = price[i];
				maxima[i] = max;
			} else {
				maxima[i] = max;
			}
		}
		for (int i = 0; i < price.length; i++) {
			if (i == 0 || (price[i] < min && price[i] < price[i - 1]) || (price[i] > min && price[i] < price[i-1])) {
				min = price[i];
				minima[i] = min;
			} else if (price[i] > min && price[i] > price[i - 1]) {
				minima[i] = min;
			}
		}
		int count = 0;
		for (int i = 0; i < price.length; i++) {
			if ((price[i] == minima[i] || price[i] == maxima[i]) && (maxima[i] - minima[i] > 0)) {
				count++;
				if (count % 2 == 1) {
					System.out.print("(" + i + " ");
				} else {
					System.out.print(i + ")" + " ");
				}
			}
		}

		if (count == 0) {
			System.out.print("No Profit");
		}
	}

}
