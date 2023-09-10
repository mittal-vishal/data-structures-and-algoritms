package com.vishal.backtracking;

import java.util.*;

public class HotelBooking {

    private static HashMap<Integer,List<Room>> roomAvailability;

    static class Room{
        int price;
        HashSet<String> feature;
        int availability;
        public Room(int price, HashSet<String> feature, int availability){
            this.price = price;
            this.feature = feature;
            this.availability = availability;
        }
        @Override
        public String toString() {
            return "Room{" +
                    "price=" + price +
                    ", feature=" + feature +
                    ", availability=" + availability +
                    '}';
        }
    }

    static class Filter{
        int checkIn;
        int checkout;
        HashSet<String> feature;
        int room;
        public Filter(int checkIn, int checkout, HashSet<String> feature, int room) {
            this.checkIn = checkIn;
            this.checkout = checkout;
            this.feature = feature;
            this.room = room;
        }
    }

    public static void main(String[] args) {
        roomAvailability = new HashMap<>();
        createData();
        Filter inputFilter = new Filter(176,178,new HashSet<>(List.of("breakfast")), 1);
        List<Room> result = getRoom(inputFilter);
        System.out.println(result);
    }

    private static void createData() {
        Room room1 = new Room(120, new HashSet<>(List.of("breakfast", "refundable")), 5);
        Room room2 = new Room(130, new HashSet<>(List.of("breakfast")), 1);
        Room room3 = new Room(140, new HashSet<>(List.of("breakfast", "refundable", "wifi")), 3);
        Room room4 = new Room(130, new HashSet<>(List.of("breakfast")), 2);
        Room room5 = new Room(140, new HashSet<>(List.of("breakfast", "refundable", "wifi")), 10);
        roomAvailability.put(176, List.of(room1));
        roomAvailability.put(177, List.of(room2, room3));
        roomAvailability.put(178, List.of(room4, room5));
    }

    private static List<Room> getRoom(Filter inputFilter) {
        List<Room> result = new ArrayList<>();
        List<Room> checkInRooms = roomAvailability.get(inputFilter.checkIn);
        for(Room room: checkInRooms){
            if(isFeatureAvailable(inputFilter.feature, room.feature)){
                addCommonRooms(inputFilter.checkIn, inputFilter.checkout, inputFilter.feature, room.feature, room.availability, 0, result);
            }
        }
        return result;
    }

    private static void addCommonRooms(int checkIn, int checkout, HashSet<String> filterFeature, HashSet<String> roomFeature, int availability, int price, List<Room> result) {
        //accumulate result
        if(checkIn == checkout){
            Room newRoom = new Room(price, roomFeature, availability);
            result.add(newRoom);
            return;
        }
        List<Room> nextDayRoom = roomAvailability.get(checkIn);
        for(Room nextDay: nextDayRoom){
            if(isFeatureAvailable(roomFeature, nextDay.feature)){
                price += nextDay.price;
                HashSet<String> newFeatures = getCommonFeature(nextDay.feature, filterFeature);
                int newAvailability = Math.min(availability, nextDay.availability);
                addCommonRooms(checkIn+1, checkout, roomFeature, newFeatures, newAvailability, price, result);
                price -= nextDay.price;
            }
        }
    }

    private static HashSet<String> getCommonFeature(HashSet<String> feature, HashSet<String> filterFeature) {
        HashSet<String> set=new HashSet<>(filterFeature);
        HashSet<String> set1=new HashSet<>(feature);
        set.retainAll(set1);
        return set;
    }

    private static boolean isFeatureAvailable(HashSet<String> filterFeatures, HashSet<String> roomFeature) {
        for(String filterFeature: filterFeatures){
            if(!roomFeature.contains(filterFeature)){
                return false;
            }
        }
        return true;
    }

}

/*
*
* {

	176 : 	[
				{
					"price" : 120,
					"features" : ["breakfast", "refundable"],
					"availability" : 5
				}
			],
	177 : 	[
				{
					"price" : 130,
					"features" : ["breakfast"],
					"availability" : 1
				},
				{
					"price" : 140,
					"features" : ["breakfast", "refundable", "wifi"],
					"availability" : 3
				}
			],
	178 : 	[
				{
					"price" : 130,
					"features" : ["breakfast"],
					"availability" : 2
				},
				{
					"price" : 140,
					"features" : ["breakfast", "refundable", "wifi"],
					"availability" : 10
				}
			]
}
I/P =>

{
	"checkIn" : 176,
	"checkout" : 178,
	"features" : ["breakfast"]
	"rooms"    : 1

}
o/P =>

[
	{
		"price" : 250,
		"features" : ["breakfast"],
		"availability" : 1
	},
	{
		"price" : 260,
		"features" : ["breakfast", "refundable"],
		"availability" : 3
	}
]
*
* */
