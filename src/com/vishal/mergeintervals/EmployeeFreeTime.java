package com.vishal.mergeintervals;

import java.util.*;

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};

public class EmployeeFreeTime {

    static class EmployeeInterval{
        private Interval interval;
        private int empIndex;
        private int intervalIndex;

        public EmployeeInterval(Interval interval, int empIndex, int intervalIndex){
            this.interval = interval;
            this.empIndex = empIndex;
            this.intervalIndex = intervalIndex;
        }
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> freeIntervals = new ArrayList<>();
        if(schedule == null || schedule.size() < 2){
            return freeIntervals;
        }
        List<Interval> intervals = new ArrayList<>();
        for(int i = 0; i < schedule.size(); i++){
            for(int j = 0; j < schedule.get(i).size(); j++){
                intervals.add(schedule.get(i).get(j));
            }
        }
        Collections.sort(intervals, (a, b) -> a.start-b.start);
        Interval previous = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval currInterval = intervals.get(i);
            if(currInterval.start > previous.end){
                //Free interval
                freeIntervals.add(new Interval(previous.end, currInterval.start));
                previous = currInterval;
            }else{
                //Overlap
                //if prev end is greater than current end, then update
                currInterval.end = Math.max(previous.end, currInterval.end);
                previous = currInterval;
            }
        }
        return freeIntervals;
    }

    public static List<Interval> employeeFreeTimeOptimal(List<List<Interval>> schedule) {
        List<Interval> freeIntervals = new ArrayList<>();
        if(schedule == null || schedule.size() < 2){
            return freeIntervals;
        }

        PriorityQueue<EmployeeInterval> sortedIntervalQueue = new PriorityQueue<>((a, b) ->
                a.interval.start - b.interval.start);
        for(int i = 0; i < schedule.size(); i++){
            sortedIntervalQueue.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
        }

        Interval prevInterval = null;

        while(!sortedIntervalQueue.isEmpty()){
            EmployeeInterval currentInterval = sortedIntervalQueue.poll();
            if(prevInterval == null){
                prevInterval = currentInterval.interval;
            }else if(prevInterval.end < currentInterval.interval.start){
                //Free Employee Interval
                freeIntervals.add(new Interval(prevInterval.end, currentInterval.interval.start));
                prevInterval = currentInterval.interval;
            }else {
                //Overlap
                currentInterval.interval.end = Math.max(currentInterval.interval.end, prevInterval.end);
                prevInterval = currentInterval.interval;
            }
            if(currentInterval.intervalIndex + 1 < schedule.get(currentInterval.empIndex).size()){
                sortedIntervalQueue.offer(new EmployeeInterval(schedule.get(currentInterval.empIndex).
                        get(currentInterval.intervalIndex + 1), currentInterval.empIndex,
                        currentInterval.intervalIndex + 1));
            }
        }

        return freeIntervals;
    }

    public static void main(String[] args) {
        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(7, 24), new Interval(29, 33), new Interval(45, 57), new Interval(66, 69), new Interval(94, 99))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 24), new Interval(43, 49), new Interval(56, 59), new Interval(61, 75), new Interval(80, 81))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(5, 16), new Interval(18, 26), new Interval(33, 36), new Interval(39, 57), new Interval(65, 74))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(9, 16), new Interval(27, 35), new Interval(40, 55), new Interval(68, 71), new Interval(78, 81))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(0, 25), new Interval(29, 31), new Interval(40, 47), new Interval(57, 87), new Interval(91, 94))));
        List<Interval> result = EmployeeFreeTime.employeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();
    }

}
