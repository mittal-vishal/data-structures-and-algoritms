package com.vishal.microsoft;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        restore(s, 0, 0, "", results);
        return results;
    }

    private void restore(String s, int idx, int partition, String ans, List<String> results){
        if(idx == s.length() && partition == 4){
            results.add(ans.substring(0, ans.length() - 1));
            return;
        }
        if(idx >= s.length() || partition == 4){
            return;
        }
        restore(s, idx + 1, partition + 1, ans + s.charAt(idx) + ".", results);
        if(idx + 2 <= s.length() && isValid(s.substring(idx, idx + 2))){
            restore(s, idx + 2, partition + 1, ans + s.substring(idx, idx + 2) + ".", results);
        }
        if(idx + 3 <= s.length() && isValid(s.substring(idx, idx + 3))){
            restore(s, idx + 3, partition + 1, ans + s.substring(idx, idx + 3) + ".", results);
        }
    }

    private boolean isValid(String s){
        if(s.charAt(0) == '0'){
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

}
