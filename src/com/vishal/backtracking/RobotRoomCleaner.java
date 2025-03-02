package com.vishal.backtracking;

import java.util.HashSet;

public class RobotRoomCleaner {

    static class Robot{
        void clean(){

        }
        void turnRight(){

        }
        boolean move(){
            return true;
        }
    }

    static class Pair<T,U>{

        public Pair(U newRow, U newCol) {
        }
    }

    private HashSet<Pair<Integer,Integer>> visited;
    private Robot robot;
    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    private void backtrack(int i, int j, int dir){
        int[][] dirs = {{-1,0} ,{0,1}, {1,0}, {0,-1}};
        visited.add(new Pair<>(i,j));
        robot.clean();
        for(int k = 0; k < 4; k++){
            int newDir = (dir+k) % 4;
            int newRow = i + dirs[newDir][0];
            int newCol = j + dirs[newDir][1];
            if(!visited.contains(new Pair<>(newRow,newCol)) && robot.move()){
                backtrack(newRow,newCol,newDir);
                goBack();
            }
            robot.turnRight();
        }
    }

    private void goBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

}
