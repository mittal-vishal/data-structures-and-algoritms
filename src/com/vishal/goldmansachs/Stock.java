package com.vishal.goldmansachs;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class Stock {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		private static Map<String, Entry<Double, Integer>> map = new HashMap<String, Map.Entry<Double, Integer>>();

		@Override
		public void putNewPrice(String symbol, double price) {
			if (!map.containsKey(symbol)) {
				map.put(symbol, new SimpleEntry<Double, Integer>(price, 1));
			} else {
				double totalPrice = map.get(symbol).getKey() + price;
				map.put(symbol, new SimpleEntry<Double, Integer>(totalPrice, map.get(symbol).getValue() + 1));
			}
		}

		@Override
		public double getAveragePrice(String symbol) {
			// YOUR CODE HERE
			if (map.containsKey(symbol)) {
				return map.get(symbol).getKey() / map.get(symbol).getValue();
			} else {
				return -1;
			}
		}

		@Override
		public int getTickCount(String symbol) {
			// YOUR CODE HERE
			if (map.containsKey(symbol)) {
				return map.get(symbol).getValue();
			} else {
				return -1;
			}
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);

				stats.putNewPrice(symbol, price);

			}

			for (String symbol : symbols) {
				System.out.println(
						String.format("%s %.4f %d", symbol, stats.getAveragePrice(symbol), stats.getTickCount(symbol)));
			}
		}
		scanner.close();
	}
}