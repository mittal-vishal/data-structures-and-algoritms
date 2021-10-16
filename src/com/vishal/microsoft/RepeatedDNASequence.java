package com.vishal.microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> dnaSequenceOccurance = new HashMap<>();
        List<String> seqList = new ArrayList<>();
        for(int i = 0; i <= s.length() - 10; i++){
            String dna = s.substring(i, i + 10);
            dnaSequenceOccurance.put(dna, dnaSequenceOccurance.getOrDefault(dna, 0) + 1);
            if(dnaSequenceOccurance.get(dna) == 2){
                seqList.add(dna);
            }
        }
        return seqList;
    }

}
