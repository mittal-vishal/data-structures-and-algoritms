package com.vishal.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		int startRow = 0;
		int endRow = row-1;
		int startCol = 0;
		int endCol = col-1;
		while(result.size() != (row*col)){
			//first row
			for(int j = startCol; j <= endCol; j++){
				result.add(matrix[startRow][j]);
			}
			//last col
			for(int i = startRow + 1; i <= endRow; i++){
				result.add(matrix[i][endCol]);
			}
			//last row
			if(endRow != startRow){
				for(int j = endCol - 1; j >= startCol; j--){
					result.add(matrix[endRow][j]);
				}
			}
			//first col
			if(startCol != endCol){
				for(int i = endRow - 1; i > startRow; i--){
					result.add(matrix[i][startCol]);
				}
			}
			startRow++;
			endRow--;
			startCol++;
			endCol--;
		}
		return result;
	}

}
