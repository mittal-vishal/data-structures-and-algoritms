package com.vishal.amazon;

import java.util.HashSet;
import java.util.Set;

public class RobotSimulation {

    public static void main(String[] args) {
        RobotSimulation simulation = new RobotSimulation();
        int[] commands = {-2,-1,8,9,6};
        int[][] obstacles = {{-1,3},{0,1},{-1,5},{-2,-4},{5,4},{-2,-3},{5,-1},{1,-1},{5,5},{5,2}};
        int dist = simulation.robotSim(commands, obstacles);
        System.out.print(dist);
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirUnit = 0;
        int x = 0;
        int y = 0;
        int maxDist = 0;
        Set<String> obstacleSet = new HashSet<>();

        for(int[] obstacle: obstacles){
            obstacleSet.add(obstacle[0] + " "+ obstacle[1]);
        }

        for(int command: commands){
            if(command == -1){
                dirUnit = (dirUnit + 1) % 4;
            }else if(command == -2){
                dirUnit = (dirUnit + 3) % 4;
            }else{
                while(command-- > 0 && !obstacleSet.contains((x+dirs[dirUnit][0]) + " " + (y+dirs[dirUnit][1]))){
                    x += dirs[dirUnit][0];
                    y += dirs[dirUnit][1];
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }
        return maxDist;
    }

}
