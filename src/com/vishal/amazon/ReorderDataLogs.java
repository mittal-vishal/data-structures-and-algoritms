package com.vishal.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReorderDataLogs {


	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("asdf 13");
		list.add("rv box");
		list.add("rg box");
		list.add("asefw eat fasfaf efgseg");
		list.add("aswr has");
		list.add("as42t 52 efgseg");
		System.out.println(reorderLines(list.size(), list));
	}
	
	public static List<String> reorderLines(int logFileSize, List<String> logLines) 
	{
		List<String> numberList = new ArrayList<>();
		List<String> charList = new ArrayList<>();
		List<String> output = new ArrayList<>();
		
		int identifier = -1;
		for(String logLineStr : logLines){
		    identifier = logLineStr.split("\\ ")[1].toLowerCase().charAt(0);
		    if(identifier >= 97 && Integer.valueOf(identifier) <= 122){
		    	charList.add(logLineStr);
		    }else {
		    	numberList.add(logLineStr);
		    }
		}
		
		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] stringArray1 = {o1.substring(0, o1.indexOf(' ')), o1.substring(o1.indexOf(' ') + 1, o1.length())};
				String[] stringArray2 = {o2.substring(0, o2.indexOf(' ')), o2.substring(o2.indexOf(' ') + 1, o2.length())};
				if(!stringArray1[1].equals(stringArray2[1])) {
					return stringArray1[1].compareTo(stringArray2[1]);
				}else {
					return stringArray1[0].compareTo(stringArray2[0]);
				}
			}
		};
		
		Collections.sort(charList, comparator);
		
		output.addAll(charList);
		output.addAll(numberList);
		
		return output;
		
	}
}
