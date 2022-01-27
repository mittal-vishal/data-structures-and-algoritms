package com.vishal.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> domainCountMap = new HashMap<>();
        List<String> domainList = new ArrayList<>();
        for(int i = 0; i < cpdomains.length; i++){
            String currDomain = cpdomains[i];
            String[] subdomains = currDomain.split(" ");
            String count = subdomains[0];
            StringBuilder domain = new StringBuilder();
            String[] domains = subdomains[1].split("\\.");
            for(int j = domains.length - 1; j >= 0; j--){
                if(j == domains.length - 1){
                    domain = new StringBuilder(domains[j]);
                }else{
                    domain = new StringBuilder(domains[j]).append(".").append(domain);
                }
                String key = domain.toString();
                domainCountMap.put(key, domainCountMap.getOrDefault(key, 0) + Integer.valueOf(count));
            }
        }
        for(Map.Entry<String, Integer> entry: domainCountMap.entrySet()){
            StringBuilder res = new StringBuilder(entry.getValue()+" ").append(entry.getKey());
            domainList.add(res.toString());
        }
        return domainList;
    }

}
