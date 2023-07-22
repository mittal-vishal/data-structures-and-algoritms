package com.vishal.backtracking;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NormalizeURLRegx {

    private Pattern pattern = Pattern.compile("%(.+?)%");

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("USER", "admin");
        map.put("HOME", "/%USER%/home");
        String input = "I am %USER% My home is %HOME%";
        NormalizeURLRegx google = new NormalizeURLRegx();
        String s = google.normalize(input, map);
        System.out.println(s);
    }

    private String normalize(String text, Map<String, String> dict) {
        normalize(dict);
        Set<String> ph = placeHolders(text);
        for (String key : ph) text = text.replaceAll("%"+key+"%", dict.get(key));
        return text;
    }

    private Set<String> placeHolders(String text) {
        Matcher matcher = pattern.matcher(text);
        Set<String> set = new HashSet<>();
        while (matcher.find()) set.add(matcher.group(1));
        return set;
    }

    private Map<String, String> normalize(Map<String, String> dict) {
        Queue<String> queue = new LinkedList<>();

        //~ build graph,
        Map<String, Set<String>> produces = new HashMap<>();
        Map<String, Set<String>> consumes = new HashMap<>();
        for(String key : dict.keySet()) {
            Set<String> phs = placeHolders(dict.get(key));//    "/%USER%/home"
            consumes.putIfAbsent(key, new HashSet<>());
            consumes.get(key).addAll(phs);//{ "home" , ["USER"] }
            for(String ph : phs) {
                produces.putIfAbsent(ph, new HashSet<>());
                produces.get(ph).add(key); //{ "USER" : ["HOME"]}
            }
            if(consumes.get(key).isEmpty()) queue.add(key);
        }

        //top sort
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            visited.add(curr);
            Set<String> neighbour = produces.getOrDefault(curr, new HashSet<>());
            for(String next : neighbour) {
                String value = dict.get(next);
                value = value.replaceAll("%"+curr+"%", dict.get(curr));
                dict.put(next, value);
                consumes.get(next).remove(curr);
                if(consumes.get(next).isEmpty()) queue.add(next);
            }
        }

        return dict;
    }

}
