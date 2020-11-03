package com.vishal.goldmansachs;

public class RobotBoundedInCircle {
	
	public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{-1,0},{0, -1},{1, 0},{0, 1}}; // north, west, south, east
        int x = 0, y = 0, dir = 0;
        for (char instruction : instructions.toCharArray()){
            if (instruction == 'G'){
                x += dirs[dir][0];
                y += dirs[dir][1];
            } else if (instruction == 'L'){
                dir = (dir + 1) % 4;
            } else {
                dir = (dir + 3) % 4;
            }
        }
        return (x == 0 && y == 0) || (dir != 0);
    }
	
}
