package com.vishal.microsoft;

public class CanPlaceFlower {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; ){
            if(flowerbed[i] == 1){
                i = i + 2;
            }else if(flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i-1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i+1] == 0)){
                n--;
                i = i + 2;
            }else{
                i++;
            }
        }
        if(n > 0){
            return false;
        }else{
            return true;
        }
    }

}
