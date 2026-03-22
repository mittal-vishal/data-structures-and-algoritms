package com.vishal.atlassian.codedesign;

import com.vishal.atlassian.codedesign.productsubscription.*;

import java.time.LocalDate;
import java.util.Map;

public class Driver {

    public static void main(String[] args) {
        // Create products with trial periods
        Product jira = new Product("JIRA", 10.0, 14);         // 14-day trial
        Product confluence = new Product("CONFLUENCE", 7.5, 30); // 30-day trial
        Product bitbucket = new Product("BITBUCKET", 8.0, 7);    // 7-day trial

        // Billing service
        BillingService billingService = new BillingService();

        // Subscriptions with different discounts
        billingService.addSubscription(new UserSubscription(
                "user1", jira, LocalDate.of(2025, 2, 15), new FlatDiscount(5))); // Trial ends Mar 1, charge from Mar

        billingService.addSubscription(new UserSubscription(
                "user1", confluence, LocalDate.of(2025, 1, 10), new PercentageDiscount(0.10))); // Trial ends Feb 9

        billingService.addSubscription(new UserSubscription(
                "user1", bitbucket, LocalDate.of(2025, 5, 1), new NoDiscount())); // Trial ends May 8

        // Compute bill
        Map<String, Double> yearlyBill = billingService.calculateBill("user1", 2025);

        // Print results
        System.out.println("Annual Billing Summary for user1 (2025):");
        for (Map.Entry<String, Double> entry : yearlyBill.entrySet()) {
            System.out.printf("%s: $%.2f%n", entry.getKey(), entry.getValue());
        }
    }
}
