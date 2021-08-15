package com.vishal.stack;
import java.util.Stack;

class Pair{
	int data;
	int pos;

	public Pair(int data, int pos){
		this.data = data;
		this.pos = pos;
	}
}

class StockSpanner {

	private Stack<Pair> stack;
	private int index;

	public StockSpanner() {
		this.stack = new Stack<>();
		this.index = 0;
	}

	public int next(int price) {
		int res = 1;
		while(!stack.isEmpty() && price >= stack.peek().data){
			stack.pop();
		}
		if(!stack.isEmpty()){
			res = index - stack.peek().pos;
		}else{
			res += index;
		}
		stack.push(new Pair(price,index));
		index++;
		return res;
	}
}