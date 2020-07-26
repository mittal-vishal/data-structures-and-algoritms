package com.vishal.goldmansachs;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
	
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(50, 22));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		Long div = num / den;
		Long mod = num % den;
		String res = "";
		if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
			res += "-";
		}
		if (mod == 0) {
			return res + div;
		} else {
			res += String.valueOf(div) + ".";
			Map<Long, Integer> map = new HashMap<>();
			while (mod != 0) {
				if (map.containsKey(mod)) {
					Integer idx = map.get(mod);
					res = res.substring(0, idx) + "(" + res.substring(idx, res.length()) + ")";
					return res;
				} else {
					map.put(mod, res.length());
					div = (mod * 10) / den;
					mod = (mod * 10) % den;
					res += div;
				}
			}
		}
		return res;
	}
	
}
