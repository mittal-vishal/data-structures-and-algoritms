package com.vishal.arrays;

public class PourWater {

    public static void main(String[] args) {
        int[] level = {2,1,1,2,1,2,2};
        int volume = 4;
        int k = 3;
        PourWater pourWater = new PourWater();
        int[] res = pourWater.pourWater(level, volume, k);
        for(int i: res) {
            System.out.println(i);
        }
    }

    public int[] pourWater(int[] heights, int volume, int k) {
        int j = k;
        for(int i  = 0; i < volume; i++){
            //flow in left dir
            while(j > 0 && heights[j-1] <= heights[j]){
                j--;
            }
            while(j < heights.length-1 && heights[j] >= heights[j+1]){
                j++;
            }
            while(j > k && heights[j] == heights[j-1]){
                j--;
            }
            heights[j]++;
        }
        return heights;
    }

}
