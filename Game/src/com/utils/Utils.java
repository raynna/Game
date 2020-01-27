package com.utils;

public class Utils {
	
	public static final int getRandom(int maxValue) {
		return (int) (Math.random() * (maxValue + 1));
	}

	public static final int random(int min, int max) {
		return Math.min(min, max + 1) + 1;
	}

}
