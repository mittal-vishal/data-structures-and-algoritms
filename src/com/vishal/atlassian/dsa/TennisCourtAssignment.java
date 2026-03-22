package com.vishal.atlassian.dsa;

/*
*
*You are given a list of tennis court bookings. Each booking has a unique ID, a start time, and a finish time. Your task is to assign each booking to a tennis court such that:

No two bookings on the same court overlap in time.

You use the minimum number of courts possible.

There are unlimited courts available.

Implement a function that takes the list of bookings and returns a mapping of each booking to a court ID.
* */

import java.util.*;

public class TennisCourtAssignment {

    static class BookingRecord {
        int id;         // Unique ID of the booking
        int startTime; // Start time of the booking
        int endTime; // Finish time of the booking
        int courtId;
        public BookingRecord(int id, int startTime, int endTime){
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class AssignedBooking {
        int bookingId;
        int courtId;
        public AssignedBooking(int bookingId, int courtId){
            this.bookingId = bookingId;
            this.courtId = courtId;
        }
        @Override
        public String toString(){
            return "booking id = " + bookingId + ", court id = " + courtId;
        }
    }

    public static void main(String[] args) {
        List<BookingRecord> bookings = new ArrayList<>(List.of(
                new BookingRecord(1, 0, 30),
                new BookingRecord(2, 5, 10),
                new BookingRecord(3, 15, 20),
                new BookingRecord(4, 35, 40),
                new BookingRecord(5, 25, 50)
        ));
        TennisCourtAssignment assignment = new TennisCourtAssignment();
        List<AssignedBooking> assignedBookings = assignment.assignCourts(bookings);
        System.out.println(assignedBookings);
    }

    public List<AssignedBooking> assignCourts(List<BookingRecord> bookingRecords){
        Collections.sort(bookingRecords, (a,b) -> a.startTime-b.startTime);
        PriorityQueue<BookingRecord> allocatedQueue = new PriorityQueue<>((a,b) -> a.endTime-b.endTime);
        TreeSet<Integer> availableCourts = new TreeSet<>();
        int courtId = 0;
        List<AssignedBooking> result = new ArrayList<>();
        for(BookingRecord bookingRecord: bookingRecords){
            //free allocated queue from the booking which is expired, and add in available queue
            while(!allocatedQueue.isEmpty() && allocatedQueue.peek().endTime <= bookingRecord.startTime){
                availableCourts.add(allocatedQueue.poll().courtId);
            }
            int currCourtId = availableCourts.isEmpty() ? courtId++ : availableCourts.pollFirst();
            result.add(new AssignedBooking(bookingRecord.id, currCourtId));
            bookingRecord.courtId = currCourtId;
            allocatedQueue.add(bookingRecord);
        }
        return result;
    }

}
