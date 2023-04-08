package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathToGivenNode {

	private List<Integer> answerList;

	public int[] solve(TreeNode A, int B) {
		List<Integer> resultList = new ArrayList<>();
		dfs(A, B, resultList);
		int[] res = new int[answerList.size()];
		for(int i = 0; i < answerList.size(); i++){
			res[i] = answerList.get(i);
		}
		return res;
	}

	private void dfs(TreeNode A, int B, List<Integer> resultList){
		if(A == null){
			return;
		}else if(A.val == B){
			resultList.add(A.val);
			answerList = new ArrayList<>(resultList);
			return;
		}else{
			resultList.add(A.val);
		}
		dfs(A.left, B, resultList);
		dfs(A.right, B, resultList);
		resultList.remove(resultList.size()-1);
	}

}
