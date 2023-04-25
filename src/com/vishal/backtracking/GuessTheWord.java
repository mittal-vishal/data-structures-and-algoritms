package com.vishal.backtracking;

import java.util.*;

public class GuessTheWord {

    private static class CharMatch {
        String key;
        int matches;

        public CharMatch(String key, int matches) {
            this.key = key;
            this.matches = matches;
        }
    }

    public static void main(String[] args) {
        // {{"MOXTE",3} , {"AXCDG",0},{"MOQRT",2},{"FOUSE",4},{"POWER",1}
        CharMatch[] input = {
                new CharMatch("MOXTE", 3),
                new CharMatch("AXCDG", 0),
                new CharMatch("MOQRT", 2),
                new CharMatch("FOUSE", 4),
                new CharMatch("POWER", 1)
        };

        Set<String> dict = new HashSet<>();
        dict.add("MOUSE");
        dict.add("HOUSE");
        System.out.println(findWord(input, dict));
    }

    public static String findWord(CharMatch[] input, Set<String> dict) {
        Map<Integer, Map<Character, Integer>> indexCharWeights = new HashMap<>();
        for (CharMatch charMatch : input) {
            for (int i = 0; i < charMatch.key.length(); i++) {
                Map<Character, Integer> map = indexCharWeights.getOrDefault(i, new HashMap<>());
                map.put(charMatch.key.charAt(i), map.getOrDefault(charMatch.key.charAt(i), 0) + charMatch.matches);
                indexCharWeights.put(i, map);
            }
        }

        StringBuilder sb = new StringBuilder();
        search(indexCharWeights, 0, sb, dict);
        return sb.toString();
    }

    private static boolean search(Map<Integer, Map<Character, Integer>> indexCharWeights, int index, StringBuilder sb, Set<String> dict) {
        if (!indexCharWeights.containsKey(index)) {
            return dict.contains(sb.toString());
        }

        Map<Character, Integer> charWeights = indexCharWeights.get(index);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(charWeights.entrySet());
        list.sort((a,b) -> b.getValue()- a.getValue());

        for (Map.Entry<Character, Integer> entry : list) {
            char c = entry.getKey();
            sb.append(c);
            if (search(indexCharWeights, index + 1, sb, dict)) {
                return true;
            }
            sb.setLength(sb.length() - 1);
        }
        return false;
    }

}
