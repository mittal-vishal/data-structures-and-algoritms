package com.vishal.search;


/*
* Given number of pages in n different books and m students. The books are
* arranged in ascending order of number of pages. Every student is assigned
* to read some consecutive books. The task is to assign books in such a way
* that the maximum number of pages assigned to a student is minimum
*
* Input : pages[] = {12, 34,67, 90} , m(number of students) = 2
* Output = 113
*
* */


public class MinPages {

    public static void main(String[] args) {
        int[] pages = {12, 34, 67, 90};
        int m = 2;
        int minPage = minimizePages(pages, m);
        System.out.print(minPage);
    }

    public static int minimizePages(int[] pages, int m){
        if(pages == null || pages.length == 0){
            return -1;
        }
        int min = pages[pages.length - 1];
        int max = getAllPages(pages);
        int ans = Integer.MAX_VALUE; //to be updated as per max value possible in this problem
        if(pages.length < m){
            return 0;
        }

        while(min <= max){
            int mid = min + (max - min)/2;
            if(isPossible(pages, m, mid)){
                ans = Math.min(ans, mid);
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return ans;
    }
    //[12, 34, 67, 90] , m = 2
    private static boolean isPossible(int[] pages, int m, int guess){
        int index = 0;
        for(int i = 0; i < m; i++){
            int pageLimit = guess;
            while(index < pages.length && pageLimit >= 0){
                if((pageLimit - pages[index]) >=0 ){
                    pageLimit -= pages[index++];
                }else{
                    if(i < m - 1 || index == pages.length){
                        break;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }



    private static int getAllPages(int[] pages){
        int totalPages = 0;
        for(int i = 0; i < pages.length; i++ ){
            totalPages += pages[i];
        }
        return totalPages;
    }


}
