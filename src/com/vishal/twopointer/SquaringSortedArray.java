package com.vishal.twopointer;

public class SquaringSortedArray {

    public static int[] makeSquaresUsingMergeProcedure(int[] arr) {
        int[] squares = new int[arr.length];
        int firstPos = -1;
        int lastNegative = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0){
                firstPos = i;
                break;
            }
        }
        if(firstPos != 0){
            lastNegative = firstPos - 1;
        }
        int index = 0;
        while(firstPos < arr.length && lastNegative >= 0){
            if(Math.abs(arr[lastNegative]) > Math.abs(arr[firstPos])){
                squares[index++] = arr[firstPos] * arr[firstPos];
                firstPos++;
            }else{
                squares[index++] = arr[lastNegative] * arr[lastNegative];
                lastNegative--;
            }
        }
        while(firstPos < arr.length){
            squares[index++] = arr[firstPos] * arr[firstPos];
            firstPos++;
        }
        while(lastNegative >= 0){
            squares[index++] = arr[lastNegative] * arr[lastNegative];
            lastNegative--;
        }
        return squares;
    }

    public static int[] makeSquaresUsing2Pointers(int[] arr) {
        int[] squares = new int[arr.length];
        int left = 0, right = arr.length - 1;
        int highestIdx = arr.length - 1;
        while(left < right){
            if((arr[left]*arr[left]) > (arr[right]*arr[right])){
                squares[highestIdx--] = arr[left]*arr[left];
                left++;
            }else{
                squares[highestIdx--] = arr[right]*arr[right];
                right--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {

        int[] result = SquaringSortedArray.makeSquaresUsing2Pointers(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }

}
