package com.vishal.goldmansachs;

public class ReachingPoint {
	
	public static void main(String[] args) {
		System.out.println(reachingPoints(1, 1, 3, 5));
	}
	
	public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
		if(tx == sx && ty == sy){
            return true;
        }else if(tx  < sx || ty < sy ){
            return false;
        }else if(tx  == sx && ty > sy){
            if((ty - sy) % tx == 0){
                return true;
            }else{
                return false;
            }
        }else if(ty == sy && tx > sx){
            if((tx - sx) % ty == 0){
                return true;
            }else{
                return false;
            }
        }else{
        	return reachingPoints(sx, sy, tx - ty, ty) || reachingPoints(sx, sy, tx, ty - tx);
        }
    }
	
}
