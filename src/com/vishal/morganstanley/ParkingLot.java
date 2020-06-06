package com.vishal.morganstanley;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ParkingLot {

	public static void main(String[] args) {
		int[][] parking = {{5,10}, {0,20}, {25,40}, {35,45}};
		System.out.println(minParkingSpaces(parking));
	}
	
	public static int minParkingSpaces(int[][] parkingStartEndTimes) {
        // YOUR CODE HERE
		  Map<String, Integer> map = new HashMap<>();
		  String mapKey = null;
		  int startInterval = -1, endInterval = -1;
		  Entry<String, Integer> existedEntry = null;
		  for(int i = 0; i < parkingStartEndTimes.length; i++){
			  boolean isExist = false;
			  for(Entry<String, Integer> entry : map.entrySet()){
				  mapKey = entry.getKey();
				  startInterval = Integer.valueOf(mapKey.split("\\,")[0]);
				  endInterval = Integer.valueOf(mapKey.split("\\,")[1]);
				  if(parkingStartEndTimes[i][0] >= startInterval && parkingStartEndTimes[i][0] <= endInterval||
				    parkingStartEndTimes[i][1] >= startInterval && parkingStartEndTimes[i][1] <= endInterval||
				    startInterval >= parkingStartEndTimes[i][0] && startInterval <= parkingStartEndTimes[i][1]||
				    endInterval >= parkingStartEndTimes[i][0] && endInterval <= parkingStartEndTimes[i][1]){
						isExist = true;
						existedEntry = entry;
				  }
			  }
			  if(isExist){
				  map.put(existedEntry.getKey(), existedEntry.getValue() + 1);
			  }else{
				  map.put(parkingStartEndTimes[i][0] + "," + parkingStartEndTimes[i][1], 1);
			  }
		  }
		  int max = Integer.MIN_VALUE;
		  int returnVal = -1;
		  for(Entry<String, Integer> entry : map.entrySet()){
			  if(entry.getValue() > max){
				  max = entry.getValue();
				  returnVal = entry.getValue();
			  }
		  }
		  return returnVal;
	}

}
