package com.vishal.wayfair;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IPAddressRegions {

    public static List<Integer> getRegions(List<String> ip_addresses) {
        List<Integer> result = new ArrayList<>();
        getRegions(ip_addresses, 0, result);
        return result;
    }

    private static void getRegions(List<String> ip_addresses, int i, List<Integer> result){
        if(i == ip_addresses.size()){
            return;
        }
        try{
            long startIPAddress1 = ipToLongInt(InetAddress.getByName("0.0.0.0"));
            long endIPAddress1 = ipToLongInt(InetAddress.getByName("127.255.255.255"));

            long startIPAddress2 = ipToLongInt(InetAddress.getByName("128.0.0.0"));
            long endIPAddress2 = ipToLongInt(InetAddress.getByName("191.255.255.255"));

            long startIPAddress3 = ipToLongInt(InetAddress.getByName("192.0.0.0"));
            long endIPAddress3 = ipToLongInt(InetAddress.getByName("223.255.255.255"));

            long startIPAddress4 = ipToLongInt(InetAddress.getByName("224.0.0.0"));
            long endIPAddress4 = ipToLongInt(InetAddress.getByName("239.255.255.255"));

            long startIPAddress5 = ipToLongInt(InetAddress.getByName("240.0.0.0"));
            long endIPAddress5 = ipToLongInt(InetAddress.getByName("255.255.255.255"));

            for(;i < ip_addresses.size();i++){
                String inputAddress = ip_addresses.get(i);
                long inputIpLong = ipToLongInt(InetAddress.getByName(inputAddress));
                if(inputIpLong >= startIPAddress1 && inputIpLong <= endIPAddress1){
                    result.add(1);
                }else if(inputIpLong >= startIPAddress2 && inputIpLong <= endIPAddress2){
                    result.add(2);
                }else if(inputIpLong >= startIPAddress3 && inputIpLong <= endIPAddress3){
                    result.add(3);
                }else if(inputIpLong >= startIPAddress4 && inputIpLong <= endIPAddress4){
                    result.add(4);
                }else if(inputIpLong >= startIPAddress5 && inputIpLong <= endIPAddress5){
                    result.add(5);
                }else{
                    result.add(-1);
                }
            }
        }catch(Exception exception){
            result.add(-1);
            getRegions(ip_addresses, i+1, result);
        }
    }

    private static long ipToLongInt(InetAddress ipAddress){
        long result = 0;
        byte[] ipAddressOctet = ipAddress.getAddress();
        for(byte octet: ipAddressOctet){
            result <<= 8;
            result |= octet & 0xFF;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("123.211.102.13", "423.211.102.13","223.211.102.13");
        System.out.println(getRegions(input));
    }

}
