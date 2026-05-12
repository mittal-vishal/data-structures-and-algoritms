package com.vishal.distributed;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class CouponGenerator {

    private static final int CHUNK_SIZE = 1000;

    public List<File> createChunks(String csvFilePath){
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))){
            List<File> chunks = new ArrayList<>();
            //remove header
            br.readLine();
            String line;
            List<String> chunkData = new ArrayList<>();
            while((line = br.readLine()) != null){
                chunkData.add(line);
                if(chunkData.size() >= CHUNK_SIZE){
                    File newChunk = saveAndSortChunkData(chunkData);
                    chunks.add(newChunk);
                    chunkData.clear();
                }
            }
            if(!chunkData.isEmpty()){
                chunks.add(saveAndSortChunkData(chunkData));
            }
            return chunks;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private File saveAndSortChunkData(List<String> chunkData) throws IOException {
        List<ChunkEntry> chunkEntries = new ArrayList<>();
        for(String chunk: chunkData) {
            String[] chunks = chunk.split(",");
            String accountId = chunks[0];
            double amount = Double.parseDouble(chunks[1]);
            chunkEntries.add(new ChunkEntry(accountId, amount));
        }
        chunkEntries.sort((a, b) -> {
            if (!a.getAccountId().equals(b.getAccountId())) {
                return a.getAccountId().compareTo(b.getAccountId());
            } else {
                return Double.compare(a.getAmount(), b.getAmount());
            }
        });
        File newFile = File.createTempFile("chunk-", ".tmp");
        newFile.deleteOnExit();
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(newFile)))) {
            for (ChunkEntry chunkEntry: chunkEntries) {
                writer.println(chunkEntry.getAccountId() + "," + chunkEntry.getAmount());
            }
        }
        return newFile;
    }

    public int createCoupons(List<File> chunkFiles) throws IOException {
        PriorityQueue<ChunkData> pq = new PriorityQueue<>((a,b) -> {
            if (!a.getAccountId().equals(b.getAccountId())) {
                return a.getAccountId().compareTo(b.getAccountId());
            } else {
                return Double.compare(a.getAmount(), b.getAmount());
            }
        });
        List<BufferedReader> readers = new ArrayList<>();
        int totalCoupons = 0;
        try{
            for(int i = 0; i < chunkFiles.size(); i++){
                File chunkFile = chunkFiles.get(i);
                BufferedReader br = new BufferedReader(new FileReader(chunkFile));
                readers.add(br);
                refillPq(pq, br, i);
            }
            String prevAccountId = null;
            List<Double> tempDataBuffer = new ArrayList<>();
            while(!pq.isEmpty()) {
                ChunkData curr = pq.poll();
                if(prevAccountId != null && !curr.getAccountId().equals(prevAccountId)){
                    totalCoupons += processAccountIdForCoupons(tempDataBuffer, prevAccountId);
                    tempDataBuffer.clear();
                }
                tempDataBuffer.add(curr.getAmount());
                prevAccountId = curr.getAccountId();
                refillPq(pq, readers.get(curr.getIndex()), curr.getIndex());
            }
            if(!tempDataBuffer.isEmpty()){
                totalCoupons += processAccountIdForCoupons(tempDataBuffer, prevAccountId);
            }
        } finally {
            for(BufferedReader reader: readers){
                reader.close();
            }
        }
        return totalCoupons;
    }

    private int processAccountIdForCoupons(List<Double> tempDataBuffer, String prevAccountId) {
        int left = 0;
        int right = tempDataBuffer.size()-1;
        int totalCoupons = 0;
        while(right >= 0 && tempDataBuffer.get(right) > 10000){
            createCoupon(prevAccountId);
            totalCoupons++;
            right--;
        }
        //Apply 2 pointers
        while (left < right) {
            if((tempDataBuffer.get(left) + tempDataBuffer.get(right)) > 10000) {
                createCoupon(prevAccountId);
                totalCoupons++;
                left++;
                right--;
            }{
                left++;
            }
        }
        return totalCoupons;
    }

    private void createCoupon(String accountId){
        //logic to create coupon
    }

    private void refillPq(PriorityQueue<ChunkData> pq, BufferedReader br, int i) throws IOException {
        String data = br.readLine();
        if(data != null){
            String[] chunks = data.split(",");
            pq.offer(new ChunkData(i, chunks[0], Double.parseDouble(chunks[1])));
        }
    }

}
