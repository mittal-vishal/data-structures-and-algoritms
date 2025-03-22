package com.vishal.search;

public class SeparateSquare {

    private static final double PRECISION = 1e-5;

    public double separateSquares(int[][] squares) {
        double beg = 0;
        double end = 0;
        beg = getMinYCoordinate(squares);
        end = getMaxYCoordinate(squares);
        while((end-beg) > PRECISION){
            double midY = beg + (end-beg)/2;
            if(isBelowAreaIsLarger(squares, midY)){
                end = midY;
            }else{
                beg = midY;
            }
        }
        return beg;
    }

    private boolean isBelowAreaIsLarger(int[][] squares, double midY){
        double upperArea = 0;
        double lowerArea = 0;
        for(int[] square: squares){
            double bottomLeftY = square[1];
            double topLeftY = square[1] + square[2];
            double side = square[2];
            if(midY >= topLeftY){
                lowerArea += side * side;
            }else if(midY <= bottomLeftY){
                upperArea += side * side;
            }else{
                lowerArea += (midY-bottomLeftY) * side;
                upperArea += (topLeftY-midY) * side;
            }
        }
        return lowerArea >= upperArea;
    }

    private double getMinYCoordinate(int[][] squares){
        double minY = squares[0][1];
        for(int i = 1; i < squares.length; i++){
            int[] square = squares[i];
            minY = Math.min(minY, square[1] * 1.0);
        }
        return minY;
    }

    private double getMaxYCoordinate(int[][] squares){
        double maxY = squares[0][1] + squares[0][2];
        for(int i = 1; i < squares.length; i++){
            int[] square = squares[i];
            maxY = Math.max(maxY, square[1] + square[2] * 1.0);
        }
        return maxY;
    }

}
