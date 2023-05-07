package com.vishal.graph;

public class DetonateMaxBombs {

    private int count;

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int result = 0;
        for(int i = 0; i < n; i++){
            count = 0;
            dfs(i, bombs, new boolean[n]);
            result = Math.max(result, count);
        }
        return result;
    }

    private void dfs(int src, int[][] bombs, boolean[] visited){
        count++;
        visited[src] = true;
        for(int i = 0; i < bombs.length; i++){
            if(!visited[i] && inRange(bombs[src], bombs[i])){
                visited[i] = true;
                dfs(i, bombs, visited);
            }
        }
    }

    private boolean inRange(int[] a, int[] b) {
        long dx = a[0] - b[0], dy = a[1] - b[1], r = a[2];
        return dx * dx + dy * dy <= r * r;
    }

}
