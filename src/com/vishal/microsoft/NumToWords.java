package com.vishal.microsoft;

public class NumToWords {

    private static final String[] ones = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private static final String[] tens = {"", "","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private static final String[] special = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        return solve(num);
    }

    private String solve(int num){
        StringBuilder sb = new StringBuilder();
        if(num < 10){
            sb.append(ones[num]);
        }else if(num < 20){
            sb.append(special[num-10]);
        }else if(num < 100){
            sb.append(tens[num/10] + " " + solve(num%10));
        }else if(num < 1000){
            sb.append(ones[num/100] + " Hundred " + solve(num%100));
        }else if(num < 1000000){
            sb.append(solve(num/1000) + " Thousand " + solve(num%1000));
        }else if(num < 1000000000){
            sb.append(solve(num/1000000) + " Million " + solve(num%1000000));
        }else{
            sb.append(solve(num/1000000000) + " Billion " + solve(num%1000000000));
        }
        return sb.toString().trim();
    }

}
