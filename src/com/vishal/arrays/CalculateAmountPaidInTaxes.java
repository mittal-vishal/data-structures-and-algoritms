package com.vishal.arrays;

public class CalculateAmountPaidInTaxes {

    public double calculateTax(int[][] brackets, int income) {
        double totalTax = 0d;
        int index = 0;
        int totalConsumed = 0;
        while(income > 0){
            int bracketAmt = brackets[index][0];
            int taxRate = brackets[index][1];
            if(index < brackets.length-1 && income > (bracketAmt-totalConsumed)){
                totalTax += (taxRate * (bracketAmt-totalConsumed))/100d;
                income -= (bracketAmt-totalConsumed);
                totalConsumed += (bracketAmt-totalConsumed);
            }else{
                totalTax += (taxRate * income)/100d;
                income = 0;
            }
            index++;
        }
        return totalTax;
    }

}
