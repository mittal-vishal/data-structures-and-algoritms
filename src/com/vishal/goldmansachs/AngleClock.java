package com.vishal.goldmansachs;

public class AngleClock {

	public double angleClock(int hour, int minutes) {

		int minAngle = 6 * minutes;
        int hAngle = hour == 12 ? 0 : (hour * 30);
        
        double extraHAngle = (0.5 * minutes);
        
        double retAngle = Math.abs(minAngle - hAngle);
        
        if(minAngle > hAngle){
            retAngle = Math.abs(retAngle - extraHAngle);
        }else{
            retAngle = retAngle + extraHAngle;
        }
        
        retAngle = Math.min(retAngle, Math.abs(360 - retAngle));
        
        return retAngle;

	}

}
