package com.vishal.atlassian.dsa;

import java.util.Arrays;

public class RankTeamByVotes {

    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] map = new int[26][n + 1];
        for(int i = 0; i < 26; i++){
            map[i][n] = i;
        }
        for(int i = 0; i < votes.length; i++){
            String s = votes[i];
            for(int j = 0; j < s.length(); j++){
                map[s.charAt(j)-'A'][j]++;
            }
        }
        Arrays.sort(map, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) return b[i] - a[i];
            }
            return a[n] - b[n];
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append((char)('A' + map[i][n]));
        }
        return sb.toString();
    }

}
