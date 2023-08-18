package com.vishal.amazon;

public class CheckIfStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int yDiff = coordinates[1][1] - coordinates[0][1];
        int xDiff = coordinates[1][0] - coordinates[0][0];
        for(int i = 2; i < coordinates.length; i++){
            int currYDiff = coordinates[i][1] - coordinates[i-1][1];
            int currXDiff = coordinates[i][0] - coordinates[i-1][0];
            if(yDiff * currXDiff != xDiff * currYDiff){
                return false;
            }
        }
        return true;
    }

}
