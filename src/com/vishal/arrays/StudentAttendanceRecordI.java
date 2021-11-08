package com.vishal.arrays;

public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
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
