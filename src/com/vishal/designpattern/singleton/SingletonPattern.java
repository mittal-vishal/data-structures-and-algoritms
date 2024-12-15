package com.vishal.designpattern.singleton;

public class SingletonPattern {
	
	private static volatile SingletonPattern spObj = null;
	
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
			synchronized (SingletonPattern.class){
				if(spObj == null){
					spObj = new SingletonPattern();
				}
			}
		}
		return spObj;
	}

}
