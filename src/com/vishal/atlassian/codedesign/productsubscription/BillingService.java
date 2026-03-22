package com.vishal.atlassian.codedesign.productsubscription;

import java.time.LocalDate;
import java.util.*;

public class BillingService {

    private List<UserSubscription> subscriptions;

    public BillingService(){
        this.subscriptions = new ArrayList<>();
    }

    public void addSubscription(UserSubscription userSubscription){
        this.subscriptions.add(userSubscription);
    }

    public Map<String, Double> calculateBill(String userId, int year){
        Map<String,Double> productBill = new HashMap<>();
        for (UserSubscription subscription: subscriptions){
            double totalBill = 0;
            if(!subscription.userId.equals(userId)){
                continue;
            }
            LocalDate subStartDate = subscription.startDate;
            if(subStartDate.getYear() > year){
                continue;
            }
            for(int month = 1; month <= 12; month++){
                LocalDate monthStart = LocalDate.of(year, month, 1);
                LocalDate monthEnd = monthStart.withDayOfMonth(monthStart.lengthOfMonth());
                //if sub start date is after month end
                if(subStartDate.isAfter(monthEnd)){
                    continue;
                }
                LocalDate trialEnd = subStartDate.plusDays(subscription.product.trialInDays);
                if(trialEnd.isAfter(monthEnd)){
                    continue;
                }
                //If sub start date month is same as current month
                if(trialEnd.plusDays(1).getMonthValue() == month){
                    int activeDays = monthStart.lengthOfMonth() - trialEnd.plusDays(1).getDayOfMonth();
                    totalBill += (activeDays * subscription.product.monthlyPrice) / monthStart.lengthOfMonth();
                }else{
                    totalBill += subscription.product.monthlyPrice;
                }
            }
            double discountedBill = subscription.discountStrategy.apply(totalBill);
            productBill.put(subscription.product.name, discountedBill);
        }
        return productBill;
    }

}
