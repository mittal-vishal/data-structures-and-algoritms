package com.vishal.google;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Element{
    int num;
    int index;
    public Element(int num, int index){
        this.num = num;
        this.index = index;
    }
}

public class CountSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        Element[] elementArr = new Element[nums.length];
        for(int i = 0; i < nums.length; i++){
            elementArr[i] = new Element(nums[i], i);
        }
        int[] result = new int[nums.length];
        mergeSort(elementArr, 0, elementArr.length - 1, result);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private void mergeSort(Element[] elementArr, int beg, int end, int[] res){
        if(beg < end){
            int mid = beg + (end - beg)/2;
            mergeSort(elementArr, beg, mid, res);
            mergeSort(elementArr, mid+1, end, res);
            merge(elementArr, beg, mid, end, res);
        }
    }

    private void merge(Element[] elementArr, int beg, int mid, int end, int[] res){
        int i = beg; // current index for the left array
        int j = mid + 1; // current index for the right array
        // use temp to temporarily store sorted array
        Element[] tempArr = new Element[end-beg+1];
        int idx = 0;
        int rightCounter = 0;
        while (i <= mid && j <= end) {
            if (elementArr[i].num > elementArr[j].num) {
                rightCounter++;
                tempArr[idx++] = elementArr[j++];
            } else {
                res[elementArr[i].index] += rightCounter;
                tempArr[idx++] = elementArr[i++];
            }
        }
        // when one of the subarrays is empty
        while (i <= mid) {
            res[elementArr[i].index] += rightCounter;
            tempArr[idx++] = elementArr[i++];
        }
        while (j <= end) {
            tempArr[idx++] = elementArr[j++];
        }
        // restore from temp
        for (int k = beg; k <= end; k++) {
            elementArr[k] = tempArr[k-beg];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,9,7,8,5};
        CountSmallerNumbersAfterSelf count = new CountSmallerNumbersAfterSelf();
        List<Integer> retList = count.countSmaller(nums);
        System.out.print(retList);
    }

}
