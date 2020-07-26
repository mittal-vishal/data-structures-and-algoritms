package com.vishal.goldmansachs;

public class TrappingRainWater {
	
	public int trap(int[] height) {
        if(height == null || height.length < 1){
            return 0;
        }
        int[] lMaxima = new int[height.length];
        int[] rMaxima = new int[height.length];
        int leftM = height[0];
        lMaxima[0] = 0;
        rMaxima[height.length-1] = 0;
        int rightM = height[height.length-1];
        for(int i = 1; i < height.length; i++){
            lMaxima[i] = leftM;
            if(height[i] > leftM){
                leftM = height[i];
            }
        }
        for(int i = height.length - 2; i >= 0; i--){
            rMaxima[i] = rightM;
            if(height[i] > rightM){
                rightM = height[i];
            }
        }
        int trapped = 0;
        for(int i = 1; i < height.length - 1; i++){
            if(Math.min(lMaxima[i], rMaxima[i]) - height[i] > 0){
                trapped += Math.min(lMaxima[i], rMaxima[i]) - height[i];
            }
        }
        return trapped;
    }
	
}
