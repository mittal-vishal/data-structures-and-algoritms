package com.vishal.apple;

import java.util.TreeSet;

public class ExamRoom {

    private int n;
    private TreeSet<Integer> students;

    public ExamRoom(int n) {
        this.n = n;
        this.students = new TreeSet<>();
    }

    public int seat() {
        int student = 0;
        if(students.size() == 0){
            students.add(student);
            return student;
        }
        Integer prev = null;
        int dist = students.first();
        for(Integer s: students){
            if(prev != null){
                int currDist = (s-prev)/2;
                if(currDist > dist){
                    dist = currDist;
                    student = prev + currDist;
                }
            }
            prev = s;
        }
        if(n-1-students.last() > dist){
            student = n-1;
        }
        students.add(student);
        return student;
    }

    public void leave(int p) {
        students.remove(p);
    }

}
