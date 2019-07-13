package com.vishal.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FileProblem {
	
	public static final String FILE_NAME = "C:/Users/vismittal/Desktop/trade.txt";
	
	public static void main(String[] args) throws IOException {
		File tradeFile = new File(FILE_NAME);
		System.out.println(FileProblem.getStockWiseQuantity(tradeFile));
	}
	
	public static Map<String, Integer> getStockWiseQuantity(File tradeFile) throws IOException {
		Map<String, Integer> stockMap = new LinkedHashMap<>();
		BufferedReader br = new BufferedReader(new FileReader(tradeFile));
		for(String line = br.readLine(); line != null; line = br.readLine()) {
			String[] array = line.split("\\,");
			if(!stockMap.containsKey(array[0])) {
				stockMap.put(array[0], Integer.parseInt(array[2]));
			}else {
				int qty = stockMap.get(array[0]);
				stockMap.remove(stockMap.get(array[0]));
				stockMap.put(array[0], Integer.parseInt(array[2]) + qty);
			}
		}
		br.close();
		List<Entry<String, Integer>> stockSortList = new ArrayList<>(stockMap.entrySet());
		Collections.sort(stockSortList, new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Map.Entry<String, Integer> arg0, Map.Entry<String, Integer> arg1) {
				return arg1.getValue().compareTo(arg0.getValue());
			}
		});
		Map<String, Integer> returnMap = new LinkedHashMap<>();
		for(Entry<String, Integer> entry : stockSortList) {
			returnMap.put(entry.getKey(), entry.getValue());
		}
		return returnMap;
	}

}
