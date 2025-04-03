package com.vishal.search;

import java.util.ArrayList;

public class SnapshotArray {

    static class Pair{
        int snapId;
        int val;
        public Pair(int id, int val){
            this.snapId = id;
            this.val = val;
        }
    }

    private ArrayList<Pair>[] snapshots;
    private int snapId;

    public SnapshotArray(int length) {
        snapshots = new ArrayList[length];
        for(int i = 0; i < length; i++){
            snapshots[i] = new ArrayList<>();
        }
    }

    public void set(int index, int val) {
        Pair pair = new Pair(snapId, val);
        ArrayList<Pair> snaps = snapshots[index];
        if(snaps.size() <= snapId){
            snaps.add(pair);
        }else{
            snaps.get(snaps.size()-1).val = val;
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        ArrayList<Pair> snaps = snapshots[index];
        int idx = binarySearch(snaps, snap_id);
        return idx >= snaps.size() || snap_id < snaps.get(idx).snapId ? 0 : snaps.get(idx).val;
    }

    private int binarySearch(ArrayList<Pair> snaps, int snap_id){
        int beg = 0;
        int end = snaps.size()-1;
        int res = 0;
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            if(snaps.get(mid).snapId <= snap_id){
                res = mid;
                beg = mid+1;
            }else{
                end = mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //get","set","get","snap","get"]
        //[0,1],[0,12],[0,1],[],[0,3]
        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.set(0,4);
        snapshotArray.snap();
        System.out.println(snapshotArray.get(0,1));
        snapshotArray.set(0,12);
        System.out.println(snapshotArray.get(0,1));
        snapshotArray.snap();
        System.out.println(snapshotArray.get(0,3));
    }

}
