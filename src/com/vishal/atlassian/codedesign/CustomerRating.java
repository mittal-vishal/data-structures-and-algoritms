package com.vishal.atlassian.codedesign;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CustomerRating {

    static class RatingStat{
        int total;
        int count;
        public RatingStat(int total, int count){
            this.total = total;
            this.count = count;
        }
    }

    static class UserRating{
        String userId;
        double rating;
        int count;
        public UserRating(String userId, double rating, int count){
            this.userId = userId;
            this.rating = rating;
            this.count = count;
        }

        @Override
        public String toString(){
            return "userId=" + userId + ", rating=" + rating + ", count=" + count;
        }
    }

    private HashMap<String,RatingStat> userRatings;
    private volatile boolean isDirty;
    private List<UserRating> cacheUserRatings;
    private ReentrantReadWriteLock lock;

    public CustomerRating(){
        this.userRatings = new HashMap<>();
        this.cacheUserRatings = new ArrayList<>();
        this.isDirty = false;
        this.lock = new ReentrantReadWriteLock();
    }

    public static void main(String[] args) {
        CustomerRating customerRating = new CustomerRating();
        customerRating.addRating("agent_1", 5);
        customerRating.addRating("agent_1", 3);
        customerRating.addRating("agent_2", 4);
        customerRating.addRating("agent_3", 4);
        customerRating.addRating("agent_3", 4);

        List<UserRating> ratings = customerRating.getAverageRatings();
        System.out.println(ratings);
    }

    private void addRating(String userId, double rating){
        //Out of rating check
        if(rating < 1.0 || rating > 5.0) {
            throw new IllegalArgumentException("Invalid Rating");
        }
        this.lock.writeLock().lock();
        try{
            userRatings.putIfAbsent(userId, new RatingStat(0, 0));
            RatingStat userRatingStat = userRatings.get(userId);
            userRatingStat.total += rating;
            userRatingStat.count += 1;
            //Mark cache as dirty
            isDirty = true;
        }finally {
            this.lock.writeLock().unlock();
        }
    }

    private List<UserRating> getAverageRatings(){
        this.lock.readLock().lock();
        try{
            if(!isDirty){
                return new ArrayList<>(cacheUserRatings);
            }
        }finally {
            this.lock.readLock().unlock();
        }
        this.lock.writeLock().lock();
        try{
            if(!isDirty){
                return new ArrayList<>(cacheUserRatings);
            }
            List<UserRating> averageRatings = new ArrayList<>();
            for(Map.Entry<String,RatingStat> entry: userRatings.entrySet()){
                double averageRating = entry.getValue().total / (entry.getValue().count * 1d);
                averageRatings.add(new UserRating(entry.getKey(), averageRating, entry.getValue().count));
            }
            Collections.sort(averageRatings, (a,b) -> {
                if(a.rating != b.rating){
                    return Double.compare(b.rating, a.rating);
                }else if(a.count != b.count){
                    return b.count - a.count;
                }else{
                    return a.userId.compareTo(b.userId);
                }
            });
            //mark cache as clean
            cacheUserRatings = averageRatings;
            isDirty = false;
            return cacheUserRatings;
        }finally {
            this.lock.writeLock().unlock();
        }
    }

}
