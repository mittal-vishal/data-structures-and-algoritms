package com.vishal.amazon;

public class RunningLength {

	public static void main(String[] args) {
		String str = "abbcccd";
		System.out.println(encode(str));
	}

	private static String encode(String str) {
		int count = 0;
	    StringBuilder sb = new StringBuilder();
	    char prev = '\0';
	    
        for(int i = 0; i < str.length(); i++){
            if(prev == '\0' || str.charAt(i) == prev){
                count++;
                prev = str.charAt(i);
            }else{
                sb.append(String.valueOf(prev));
                sb.append(String.valueOf(count));
                count = 1;
                prev = str.charAt(i);
            }
        }
        if(prev != '\0'){
            sb.append(String.valueOf(prev));
            sb.append(String.valueOf(count));
        }
        return sb.toString();
	}

}
