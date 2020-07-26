package com.vishal.java8;

import java.util.Set;

@FunctionalInterface
public interface FunctionalInterfaceAnagram {
	
	Set<Set<String>> anagrapGrouping(String[] words);

}
