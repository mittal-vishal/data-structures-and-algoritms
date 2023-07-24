package com.vishal.uber;

public class ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructQuadTree(grid, 0, 0, n);
    }

    private Node constructQuadTree(int[][] grid, int i, int j, int n){
        if(isSame(grid, i, j, n)){
            Node node = new Node(grid[i][j] == 1, true);
            return node;
        }
        Node root = new Node(false, false);
        root.topLeft = constructQuadTree(grid, i, j, n/2);
        root. topRight = constructQuadTree(grid, i, j+(n/2), n/2);
        root.bottomLeft = constructQuadTree(grid, i+(n/2), j, n/2);
        root.bottomRight = constructQuadTree(grid, i+(n/2), j+(n/2), n/2);
        return root;
    }

    private boolean isSame(int[][] grid, int x, int y, int length){
        for(int i = x; i < x+length; i++){
            for(int j = y; j < y+length; j++){
                if(grid[i][j] != grid[x][y]){
                    return false;
                }
            }
        }
        return true;
    }

}
