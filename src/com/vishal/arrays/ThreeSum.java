package com.vishal.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSum {

    public List<List<Integer>> threeSumOptimal(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int firstNum = nums[i];
            int left = i+1;
            int right = n-1;
            while(left < right){
                if(nums[left] + nums[right] == (-firstNum)){
                    result.add(List.of(firstNum, nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if((nums[left] + nums[right]) < (-firstNum)){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumUsingHashMap(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Set<List<Integer>> uniques = new HashSet<>();
        HashMap<Integer, Integer> occurances = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            occurances.put(nums[i], occurances.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < nums.length - 1; i++){
            occurances.put(nums[i], occurances.get(nums[i]) - 1);
            for(int j = i + 1; j < nums.length; j++){
                occurances.put(nums[j], occurances.get(nums[j]) - 1);
                if(occurances.containsKey(-(nums[i] + nums[j])) && occurances.get(-(nums[i] + nums[j])) > 0){
                    int[] tripletArr = IntStream.of(nums[i], nums[j], -(nums[i] + nums[j])).toArray();
                    Arrays.sort(tripletArr);
                    List<Integer> triplets = IntStream.of(tripletArr).boxed().collect(Collectors.toList());
                    if(!uniques.contains(triplets)){
                        results.add(triplets);
                        uniques.add(triplets);
                    }
                }
                occurances.put(nums[j], occurances.get(nums[j]) + 1);
            }
            occurances.put(nums[i], occurances.get(nums[i]) + 1);
        }
        return results;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right){
                    int triplet = nums[left] + nums[right] + nums[i];
                    if(triplet == 0){
                        results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }else if(triplet < 0)
                        left++;
                    else
                        right--;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> results = threeSumUsingHashMap(arr);
        System.out.println(results);
    }

}
