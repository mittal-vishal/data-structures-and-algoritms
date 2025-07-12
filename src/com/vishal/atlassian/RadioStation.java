package com.vishal.atlassian;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RadioStation {

    /*
Our local radio station is running a show where the songs are ordered in a very specific way.  The last word of the title of one song must match the first word of the title of the next song - for example, "Silent Running" could be followed by "Running to Stand Still".  No song may be played more than once.

Given a list of songs and a starting song, find the longest chain of songs that begins with that song, and the last word of each song title matches the first word of the next one.  Write a function that returns the longest such chain. If multiple equivalent chains exist, return any of them.

Example:
songs1 = [
    "Down By the River",
    "River of Dreams",
    "Take me to the River",
    "Dreams",
    "Blues Hand Me Down",
    "Forever Young",
    "American Dreams",
    "All My Love",
    "Cantaloop",
    "Take it All",
    "Love is Forever",
    "Young American",
    "Dreamship",
    "Every Breath You Take",
]
song1_1 = "Every Breath You Take"
chaining(songs1, song1_1) => ['Every Breath You Take', 'Take it All', 'All My Love', 'Love is Forever', 'Forever Young', 'Young American', 'American Dreams', 'Dreams']

Additional Input:
song1_2 = "Dreams"
song1_3 = "Blues Hand Me Down"
song1_4 = "Cantaloop"

songs2 = [
    "Bye Bye Love",
    "Nothing at All",
    "Money for Nothing",
    "Love Me Do",
    "Do You Feel Like We Do",
    "Bye Bye Bye",zz
    "Do You Believe in Magic",
    "Bye Bye Baby",
    "Baby Ride Easy",
    "Easy Money",
    "All Right Now",
]
song2_1 = "Bye Bye Bye"
song2_2 = "Bye Bye Love"

songs3 = [
    "Love Me Do",
    "Do You Believe In Magic",
    "Magic You Do",
    "Magic Man",
    "Man In The Mirror"
]
song3_1 = "Love Me Do"

All Test Cases:
chaining(songs1, song1_1) => ['Every Breath You Take', 'Take it All', 'All My Love', 'Love is Forever', 'Forever Young', 'Young American', 'American Dreams', 'Dreams']
chaining(songs1, song1_2) => ['Dreams']
chaining(songs1, song1_3) => ['Blues Hand Me Down', 'Down By the River', 'River of Dreams', 'Dreams']
chaining(songs1, song1_4) => ['Cantaloop']
chaining(songs2, song2_1) => ['Bye Bye Bye', 'Bye Bye Baby', 'Baby Ride Easy', 'Easy Money', 'Money for Nothing', 'Nothing at All', 'All Right Now']
chaining(songs2, song2_2) => ['Bye Bye Love', 'Love Me Do', 'Do You Feel Like We Do', 'Do You Believe in Magic']
chaining(songs3, song3_1) => ['Love Me Do', 'Do You Believe in Magic', 'Magic Man', 'Man In The Mirror']

Complexity Variable:
n = number of songs in the input
*/
    public static void main(String[] argv) {
        String[] songs1 = {
                "Down By the River",
                "River of Dreams",
                "Take me to the River",
                "Dreams",
                "Blues Hand Me Down",
                "Forever Young",
                "American Dreams",
                "All My Love",
                "Cantaloop",
                "Take it All",
                "Love is Forever",
                "Young American",
                "Dreamship",
                "Every Breath You Take"
        };
        String song1_1 = "Every Breath You Take";
        String song1_2 = "Dreams";
        String song1_3 = "Blues Hand Me Down";
        String song1_4 = "Cantaloop";

        String[] songs2 = {
                "Bye Bye Love",
                "Nothing at All",
                "Money for Nothing",
                "Love Me Do",
                "Do You Feel Like We Do",
                "Bye Bye Bye",
                "Do You Believe in Magic",
                "Bye Bye Baby",
                "Baby Ride Easy",
                "Easy Money",
                "All Right Now"
        };
        String song2_1 = "Bye Bye Bye";
        String song2_2 = "Bye Bye Love";

        String[] songs3 = {
                "Love Me Do",
                "Do You Believe In Magic",
                "Magic You Do",
                "Magic Man",
                "Man In The Mirror"
        };
        String song3_1 = "Love Me Do";
        System.out.println(findLongestPlaylist(songs1, song1_1));
        System.out.println(findLongestPlaylist(songs1, song1_2));
        System.out.println(findLongestPlaylist(songs1, song1_3));
        System.out.println(findLongestPlaylist(songs1, song1_4));
        System.out.println(findLongestPlaylist(songs2, song2_1));
        System.out.println(findLongestPlaylist(songs2, song2_2));
        System.out.println(findLongestPlaylist(songs3, song3_1));

    }

    private static List<String> findLongestPlaylist(String[] songs, String startSong){
        List<String> result = new ArrayList<>();
        if(startSong == null || startSong.length() == 0){
            return result;
        }
        List<String> path = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        dfs(songs, startSong, path, result, visited);
        return result;
    }

    private static void dfs(String[] songs, String start, List<String> path, List<String> result, HashSet<String> visited){
        if(visited.contains(start)){
            return;
        }
        path.add(start);
        visited.add(start);
        for(String nextSong: songs){
            if(isMatches(start, nextSong)){
                dfs(songs, nextSong, path, result, visited);
            }
        }
        if(path.size() > result.size()){
            result.clear();
            result.addAll(path);
        }
        path.remove(path.size()-1);
        visited.remove(start);
    }

    private static boolean isMatches(String currSong, String nextSong){
        //Verify logic
        String[] currSongWords = currSong.split("\\s+");
        String lastWord = currSongWords[currSongWords.length-1];
        String[] nextSongWords = nextSong.split("\\s+");
        String firstWord = nextSongWords[0];
        return lastWord.equals(firstWord);
    }


}
