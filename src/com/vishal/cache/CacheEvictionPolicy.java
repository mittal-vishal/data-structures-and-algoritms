package com.vishal.cache;

public class CacheEvictionPolicy {

    private String evictionType;

    public CacheEvictionPolicy(String evictionType){
        this.evictionType = evictionType;
    }

    public String getEvictionType(){
        return evictionType;
    }

}
