package com.vishal.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxValueForEachKey {

    public static void main(String[] args) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        map.put("Dev", Arrays.asList(1000, 2000));
        map.put("Devbrat", Arrays.asList(3000, 4000));
        Map<String, Integer> result = map.entrySet().stream().collect(Collectors.toMap(key -> key.getKey(), value -> value.getValue().stream().max(Integer::compareTo).orElse(null)));
        System.out.println(result);
    }

}
