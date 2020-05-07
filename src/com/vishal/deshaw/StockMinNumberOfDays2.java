package com.vishal.deshaw;

public class StockMinNumberOfDays2 {

	public static void main(String args[]) {
		int currPrice = 3;
		int buyPrice = 4000;
		int days = getDays(currPrice, buyPrice);
		System.out.println(days);
	}

	public static int getDays(int curr, int buy) {
		if(curr >= buy) {
			return curr - buy;
		}
		int count = 0, buyInside = 0;
		for(int i = 0; i < buy; i++) {
			buyInside = buy + i;
			count = 0; boolean isValid = true;
			while(buyInside > curr) {
				if(buyInside % 2 == 0) {
					buyInside = buyInside / 2;
					count++;
				}else {
					isValid = false; break;
				}
			}
			if(isValid) {
				count = count + i;
				buy = buyInside;
				break;
			}
		}
		return count + Math.abs(curr - buy);
	}

}