package com.vishal.designpattern;

public class SingletonPattern {
	
	private static SingletonPattern spObj = null;
	int data;
	
	/**
	 * Private constructor will prevent this class to be get instantiated with new object creation
	 */
	private SingletonPattern() {}
	
	/**
	 * Another way to instantiate a class
	 * @return
	 */
	public static SingletonPattern getInstance() {
		if(spObj == null) {
			spObj = new SingletonPattern();
		}
		return spObj;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
