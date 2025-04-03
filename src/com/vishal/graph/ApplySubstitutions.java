package com.vishal.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplySubstitutions {

    private HashMap<String,String> dictionary;

    public String applySubstitutions(List<List<String>> replacements, String text) {
        dictionary = new HashMap<>();
        for(List<String> replacement: replacements){
            dictionary.put(replacement.get(0), replacement.get(1));
        }
        return dfs(text);
    }

    private String dfs(String text){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) != '%'){
                sb.append(text.charAt(i));
            }else{
                int j = i+1;
                while(j < text.length() && text.charAt(j) != '%'){
                    j++;
                }
                String sub = text.substring(i+1, j);
                if(dictionary.containsKey(sub)){
                    String substitution = dictionary.get(sub);
                    String nextSubstitution = dfs(substitution);
                    sb.append(nextSubstitution);
                }
                i = j;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<List<String>> replacements = new ArrayList<>();
        List<String> replacement1 = List.of("A","abc");
        List<String> replacement2 = List.of("B","def");
        String text = "%A%_%B%";
        replacements.add(replacement1);
        replacements.add(replacement2);
        ApplySubstitutions substitutions = new ApplySubstitutions();
        System.out.println(substitutions.applySubstitutions(replacements, text));
    }

}
