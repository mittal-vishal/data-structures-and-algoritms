package com.vishal.atlassian;


/*
* You're working on a word search problem, where you need to find
* the path of a given word in a 2D character grid.
* The goal is to return the list of coordinates (row, column) corresponding to the letters forming the word,
* if the word is present in the grid.*/

import java.util.Arrays;
import java.util.List;

public class WordPathInGrid {

    public static void main(String[] args) {
        char[][] grid1 = {
                {'b', 'b', 'b', 'a', 'l', 'l', 'o', 'o'},
                {'b', 'a', 'c', 'c', 'e', 's', 'c', 'n'},
                {'a', 'l', 't', 'e', 'w', 'c', 'e', 'w'},
                {'a', 'l', 'o', 's', 's', 'e', 'c', 'c'},
                {'w', 'o', 'o', 'w', 'a', 'c', 'a', 'w'},
                {'i', 'b', 'w', 'o', 'w', 'w', 'o', 'w'}
        };

        System.out.print("access: ");
        printPath(findWord(grid1, "access"));  // Expected: [(1,1), (1,2), (1,3), (2,3), (3,3), (3,4)]

        System.out.print("balloon: ");
        printPath(findWord(grid1, "balloon")); // Expected: [(0,2), (0,3), (0,4), (0,5), (0,6), (0,7), (1,7)]
    }

    public static List<int[]> findWord(char[][] grid, String word) {

    }

    private static void printPath(List<int[]> path) {
        for (int[] coord : path) {
            System.out.print(Arrays.toString(coord) + " ");
        }
        System.out.println();
    }

}
