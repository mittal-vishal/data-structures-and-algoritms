package com.vishal.heap;

public class HeapStrucSort {

	private int value;
	private int arrayPos;
	private int arrayIndex;

	public HeapStrucSort(int value, int arrayPos, int arrayIndex) {
		super();
		this.value = value;
		this.arrayPos = arrayPos;
		this.arrayIndex = arrayIndex;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getArrayIndex() {
		return arrayIndex;
	}

	public void setArrayIndex(int arrayIndex) {
		this.arrayIndex = arrayIndex;
	}

	public int getArrayPos() {
		return arrayPos;
	}

	public void setArrayPos(int arrayPos) {
		this.arrayPos = arrayPos;
	}

}
