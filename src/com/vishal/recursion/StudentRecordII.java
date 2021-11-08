package com.vishal.recursion;

public class StudentRecordII {

    private int count;
    private static final int M = 1000000007;
    public int checkRecord(int n) {
        count = 0;
        checkRecord("", n);
        return count;
    }

    private void checkRecord(String curr, int n){
        if(n == 0 && isValidForAward(curr)){
            count = (count + 1) % M;
        }
        if(n > 0){
            checkRecord(curr + "A", n-1);
            checkRecord(curr + "L", n-1);
            checkRecord(curr + "P", n-1);
        }
    }

    private boolean isValidForAward(String s){
        int absenceCount = 0;
        boolean isCompliant = true;
        for(int i = 0; i < s.length(); i++){
            int leaveCount = 0;
            if(s.charAt(i) == 'A'){
                absenceCount++;
            }
            while(i < s.length() && s.charAt(i) == 'L'){
                leaveCount++;
                i++;
            }

            if(leaveCount >= 3){
                isCompliant = false;
                break;
            }

            if(leaveCount > 0){
                i--;
            }
        }
        if(absenceCount >= 2){
            isCompliant = false;
        }
        return isCompliant;
    }

}
