package com.vishal.designpattern.singleton;

public class SingletonPatternOptimal {

	/**
	 * Private constructor will prevent this class to be get instantiated with new object creation
	 */
	private SingletonPatternOptimal() {}

	private static class SingletonPatternHelper{
		private static final SingletonPatternOptimal INSTANCE = new SingletonPatternOptimal();
	}

	/**
	 * Another way to instantiate a class
	 * @return
	 */
	public static SingletonPatternOptimal getInstance() {
		return SingletonPatternHelper.INSTANCE;
	}

}
