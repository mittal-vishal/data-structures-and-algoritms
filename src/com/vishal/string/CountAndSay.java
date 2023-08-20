package com.vishal.string;

public class CountAndSay {

    public String countAndSay(int n) {
        String num = "1";
        for(int i = 1; i < n; i++){
            num = countAndSay(num);
        }
        return num;
    }

    private String countAndSay(String num){
        if(num.length() == 0){
            return "";
        }
        int occurance = 1;
        char prevNum = num.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < num.length(); i++){
            while(i < num.length() && num.charAt(i) == prevNum){
                i++;
                occurance++;
            }
            sb.append(occurance).append(prevNum);
            if(i < num.length()){
                prevNum = num.charAt(i);
                occurance = 1;
            }else{
                prevNum = 0;
            }
        }
        if(prevNum != 0){
            sb.append(occurance).append(prevNum);
        }
        return sb.toString();
    }

}
