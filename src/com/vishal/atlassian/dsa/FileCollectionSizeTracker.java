package com.vishal.atlassian.dsa;


/*
* Problem Statement: File and Collection Size Tracker
You are given a list of files, where each file has the following attributes:

File Name: A unique identifier for the file.

File Size: An integer representing the file size in MB.

Collections (optional): A file may belong to one or more named collections. A collection can contain multiple files, and the same file can be part of multiple collections.

Your task is to design a system that supports the following:
✅ Compute the total size of all files processed.

✅ Identify the top K collections based on their total file sizes.

The size of a collection is defined as the sum of the sizes of all files that belong to it.

If a file belongs to multiple collections, its size contributes to each of those collections independently.
*
* */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class FileCollectionSizeTracker {

    private AtomicLong totalSize = new AtomicLong(0);
    private ConcurrentHashMap<String,AtomicLong> collectionSize;
    private Set<String> processedFiles;

    static class File{
        String name;
        int size;
        List<String> collections;
        public File(String name, int size, List<String> collections){
            this.name = name;
            this.size = size;
            this.collections = collections;
        }
    }

    public FileCollectionSizeTracker(){
        collectionSize = new ConcurrentHashMap<>();
        processedFiles = ConcurrentHashMap.newKeySet();
    }

    public static void main(String[] args) throws InterruptedException {
        List<File> files = Arrays.asList(
                new File("file1.txt", 100, Arrays.asList("collection1", "collection2")),
                new File("file2.txt", 200, Arrays.asList("collection1")),
                new File("file3.txt", 150, Arrays.asList("collection2", "collection3")),
                new File("file4.txt", 300, Arrays.asList("collection3")),
                new File("file5.txt", 120, null), // No collection
                new File("file6.txt", 180, Arrays.asList("collection2")),
                new File("file1.txt", 100, Arrays.asList("collection1", "collection2")) // duplicate file
        );
        FileCollectionSizeTracker tracker = new FileCollectionSizeTracker();
        int threadCount = 5;
        tracker.processFiles(files , threadCount);
        System.out.println("Total size of files processed = " + tracker.getTotalSize());
        List<Map.Entry<String,Long>> topKCollections = tracker.getTopKCollectionBySize(2);
        System.out.println(topKCollections);
    }

    private List<Map.Entry<String, Long>> getTopKCollectionBySize(int k) {
        PriorityQueue<Map.Entry<String,Long>> minHeap = new PriorityQueue<>((a,b) -> Long.compare(a.getValue(), b.getValue()));
        for(Map.Entry<String,AtomicLong> entry: collectionSize.entrySet()){
            minHeap.offer(Map.entry(entry.getKey(), entry.getValue().get()));
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        List<Map.Entry<String,Long>> result = new ArrayList<>(minHeap);
        Collections.reverse(result);
        return result;
    }

    private void processFiles(List<File> files, int threadCount) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        CountDownLatch countDownLatch = new CountDownLatch(files.size());
        for(File file: files){
            executorService.submit(() -> {
                try {
                    processFile(file);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private void processFile(File file){
        if(!processedFiles.add(file.name)){
            return;
        }
        totalSize.addAndGet(file.size);
        if(Objects.isNull(file.collections)){
            return;
        }
        for(String collectionName: file.collections){
            collectionSize.computeIfAbsent(collectionName, k -> new AtomicLong(0)).addAndGet(file.size);
        }
    }

    private Long getTotalSize(){
        return totalSize.get();
    }

}
