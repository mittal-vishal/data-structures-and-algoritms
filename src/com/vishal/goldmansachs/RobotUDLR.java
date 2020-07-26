package com.vishal.goldmansachs;

public class RobotUDLR {

	public static void main(String[] args) { 
        String move = "UDDLLRUUUDUURUDDUULLDRRRR"; 
        System.out.println(finalPosition(move));
	}
	
	private static String finalPosition(String move) {

		int countUp = 0;
		int countDown = 0;
		int countLeft = 0;
		int countRight = 0;

		for (int i = 0; i < move.length(); i++) {
			if (move.charAt(i) == 'U')
				countUp++;

			else if (move.charAt(i) == 'D')
				countDown++;

			else if (move.charAt(i) == 'L')
				countLeft++;

			else if (move.charAt(i) == 'R')
				countRight++;
		}

		return Integer.valueOf(countRight - countLeft) + "," + Integer.valueOf(countUp - countDown);
	}
}
