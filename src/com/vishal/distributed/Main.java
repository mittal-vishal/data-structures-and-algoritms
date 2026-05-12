package com.vishal.distributed;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
*
* Given a very large csv file with millions account numbers and transaction details ,
(Buy /Sell) generate coupons based on following conditions.
Any transaction worth 10000 USD generate a coupon
Any two transaction if combined crossed 10000 USD , generate a coupon
Goal is to generate maximum coupons . The file size is more than the RAM of the system.
*
* Step 1 -> We can read the big file in smaller size chunks which can fit in RAM. The data will be ordered in chunk,
* like based on sorted order of account number and transaction amount. Store chunk in parquet files(faster in read and write).
* Step 2 -> Open all the chunk files in read mode and we can use K-Merge way to process these files.
* Step 3 -> Processing will be based on below steps
* (A) Keep accumulating in temp data buffer until we see same account. The moment we see different account. Process data buffer and clear.
* (B) We will get multiple transaction values. Read from right and create coupons if amount > 10K
* (C) Apply 2 pointer and create coupons
* */
public class Main {

    public static void main(String[] args) throws IOException {
        CouponGenerator generator = new CouponGenerator();
        String path = "/path/data.csv";
        List<File> chunkFiles = generator.createChunks(path);
        int totalTokens = generator.createCoupons(chunkFiles);
    }

}
