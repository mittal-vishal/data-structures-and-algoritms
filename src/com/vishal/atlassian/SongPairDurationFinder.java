package com.vishal.atlassian;

import java.util.Arrays;
import java.util.List;

/*
* You are given a list of songs, where each song is represented as a pair: the name of the song and its duration in the format "mm:ss". Write a function to find a pair of songs whose total duration adds up to exactly 7 minutes (i.e., 420 seconds).

If such a pair exists, return the names of the two songs. If there are multiple such pairs, return any one. If no such pair exists, return an empty list.
* */
public class SongPairDurationFinder {

    public static void main(String[] args) {
        String[][] songs = {
                {"SongA", "3:20"},
                {"SongB", "2:00"},
                {"SongC", "4:40"},
                {"SongD", "1:40"},
                {"SongE", "3:40"}
        };
        System.out.println(findPairThatSumToTargetDuration(songs));
    }

    private static List<String> findPairThatSumToTargetDuration(String[][] songs){
        Arrays.sort(songs,(s1, s2) -> {
            String duration1 = s1[1];
            String duration2 = s2[1];
            String[] mintSeconds1 = duration1.split(":");
            String[] mintSeconds2 = duration2.split(":");
            int seconds1 = Integer.valueOf(mintSeconds1[0]) * 60 + Integer.valueOf(mintSeconds1[1]);
            int seconds2 = Integer.valueOf(mintSeconds2[0]) * 60 + Integer.valueOf(mintSeconds2[1]);
            return seconds1-seconds2;
        });
        int left = 0;
        int right = songs.length-1;
        while(left < right){
            String[] songLeft = songs[left];
            String[] songRight = songs[right];
            if(getDuration(songLeft[1]) + getDuration(songRight[1]) == 7 * 60){
                return List.of(songLeft[0], songRight[0]);
            } else if(getDuration(songLeft[1]) + getDuration(songRight[1]) < 7 * 60){
                left++;
            }else{
                right--;
            }
        }
        return List.of();
    }

    private static int getDuration(String duration){
        String[] mintSeconds = duration.split(":");
        return Integer.valueOf(mintSeconds[0]) * 60 + Integer.valueOf(mintSeconds[1]);
    }

}
