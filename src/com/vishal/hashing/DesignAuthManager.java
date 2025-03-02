package com.vishal.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignAuthManager {

    private HashMap<String,Integer> authRequestExpiry;
    private int ttl;

    public DesignAuthManager(int timeToLive) {
        authRequestExpiry = new HashMap<>();
        ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        authRequestExpiry.put(tokenId, currentTime + ttl);
    }

    public void renew(String tokenId, int currentTime) {
        int existingExpiry = authRequestExpiry.getOrDefault(tokenId, 0);
        if(currentTime >= existingExpiry){
            return;
        }
        int newExpiry = currentTime + ttl;
        authRequestExpiry.put(tokenId, newExpiry);
    }

    public int countUnexpiredTokens(int currentTime) {
        List<Map.Entry<String,Integer>> keyValues = new ArrayList<>(authRequestExpiry.entrySet());
        int count = 0;
        for(Map.Entry<String,Integer> keyValue: keyValues){
            if(keyValue.getValue() > currentTime){
                count++;
            }
        }
        return count;
    }

}
