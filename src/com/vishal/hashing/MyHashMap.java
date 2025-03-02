package com.vishal.hashing;

import java.util.LinkedList;

public class MyHashMap {

    static class Entry{
        int key;
        int value;
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] map;
    private static final int MAP_SIZE = 1000;

    public MyHashMap() {
        map = new LinkedList[MAP_SIZE];
    }

    public void put(int key, int value) {
        int bucket = key % MAP_SIZE;
        if(map[bucket] == null) {
            map[bucket] = new LinkedList<Entry>();
            map[bucket].add(new Entry(key, value));
        }
        else {
            for(Entry entry : map[bucket]){
                if(entry.key == key){
                    entry.value = value;
                    return;
                }
            }
            map[bucket].add(new Entry(key, value));
        }
    }

    public int get(int key) {
        int bucket = key % MAP_SIZE;
        if(map[bucket] == null){
            return -1;
        }else{
            for(Entry entry: map[bucket]){
                if(entry.key == key){
                    return entry.value;
                }
            }
            return -1;
        }
    }

    public void remove(int key) {
        int bucket = key % MAP_SIZE;
        if(map[bucket] == null){
            return;
        }else{
            Entry toRemove = null;
            for(Entry entry: map[bucket]){
                if(entry.key == key){
                    toRemove = entry;
                }
            }
            if(toRemove == null){
                return;
            }else{
                map[bucket].remove(toRemove);
            }
        }
    }

}
