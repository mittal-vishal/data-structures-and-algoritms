package com.vishal.string;

public class CompareVersionNumber {

    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int value1 = 0;
        int value2 = 0;
        int result = 0;
        for(int i = 0; i < Math.max(versions1.length, versions2.length); i++){
            if(i >= versions1.length){
                value1 = 0;
            }else{
                String currRevision = versions1[i];
                value1 = getValueFromRevision(currRevision);
            }
            if(i >= versions2.length){
                value2 = 0;
            }else{
                String currRevision = versions2[i];
                value2 = getValueFromRevision(currRevision);
            }
            result = value1 > value2 ? 1 : value1 < value2 ? -1 : 0;
            if(result != 0){
                break;
            }
        }
        return result;
    }

    private int getValueFromRevision(String s){
        int i = 0;
        while(i < s.length() && s.charAt(i) == '0'){
            i++;
        }
        if(i == s.length()){
            return 0;
        }else{
            String val = s.substring(i, s.length());
            return Integer.valueOf(val);
        }
    }

}
