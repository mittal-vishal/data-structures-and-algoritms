package com.vishal.bookingholdings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class RewardTopKStudents {

    static class Student{
        int id;
        int score;
        String report;
        public Student(int id, String report, int score){
            this.id = id;
            this.report = report;
            this.score = score;
        }
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Integer> result = new ArrayList<>();
        HashSet<String> positives = new HashSet<>();
        for(String positiveFeedback: positive_feedback){
            positives.add(positiveFeedback);
        }
        HashSet<String> negatives = new HashSet<>();
        for(String negativeFeedback: negative_feedback){
            negatives.add(negativeFeedback);
        }
        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> {
            if(a.score != b.score){
                return b.score-a.score;
            }else{
                return a.id - b.id;
            }
        });
        for(int i = 0; i < report.length; i++){
            String reportStr = report[i];
            String[] words = reportStr.split(" ");
            int score = 0;
            for(String word: words){
                if(positives.contains(word)){
                    score += 3;
                }else if(negatives.contains(word)){
                    score -= 1;
                }
            }
            pq.offer(new Student(student_id[i], reportStr, score));
        }
        while(k-- > 0 && !pq.isEmpty()){
            result.add(pq.poll().id);
        }
        return result;
    }

    public static void main(String[] args) {
        RewardTopKStudents topKStudents = new RewardTopKStudents();
        String[] positives = {"pyuknvau","nc","hwcpe","wn"};
        String[] negative_feedback = {"bjzzjcgxv","dibldp","pmlb"};
        String[] report = {"qws z pmlb xmcugvuos lpnygddx bjzzjcgxv hwcpe pmlb pmlb rocg","hwcpe pyuknvau dibldp bjzzjcgxv bjzzjcgxv hwcpe wn pmlb pyuknvau wodnvd",
                "dibldp dibldp gna dibldp pmlb pyuknvau pyuknvau nc iygs rkhtnjreq","pmlb aas wn hwcpe bjzzjcgxv otird pyuknvau fdl bjzzjcgxv dibldp"};
        int[] student_id = {357574114,899543310,676388750,793586311};
        List<Integer> res = topKStudents.topStudents(positives, negative_feedback, report, student_id, 2);
        System.out.println(res);
    }

}
