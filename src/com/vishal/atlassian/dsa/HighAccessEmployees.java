package com.vishal.atlassian.dsa;

import java.util.*;

public class HighAccessEmployees {

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String,List<Integer>> employeeCheckins = new HashMap<>();
        for(List<String> accessTime: access_times){
            String employee = accessTime.get(0);
            Integer time = Integer.parseInt(accessTime.get(1));
            employeeCheckins.putIfAbsent(employee, new ArrayList<>());
            employeeCheckins.get(employee).add(time);
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<String,List<Integer>> entry: employeeCheckins.entrySet()){
            String emp = entry.getKey();
            List<Integer> checkins = entry.getValue();
            Collections.sort(checkins);
            if(isHighAccess(checkins)){
                result.add(emp);
            }
        }
        return result;
    }

    private boolean isHighAccess(List<Integer> checkins){
        for(int i = 2; i < checkins.size(); i++){
            int startTime = checkins.get(i-2);
            int endTime = checkins.get(i);
            if((startTime + 99) >= endTime){
                return true;
            }
        }
        return false;
    }

}
