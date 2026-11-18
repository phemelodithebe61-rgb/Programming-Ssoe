package com.mattress;

import java.util.Scanner;

/** Question 1: console entry point using both 1D and 2D arrays. */
public class SalesReportApp {
    public static final String[] PRODUCTS = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    public static void main(String[] args) {
        int[][] sales = new int[PRODUCTS.length][3];
        try (Scanner scanner = new Scanner(System.in)) {
            for (int product = 0; product < PRODUCTS.length; product++) {
                for (int month = 0; month < 3; month++) {
                    while (true) {
                        System.out.print("Enter number of sales for month " + (month + 1) + " for " + PRODUCTS[product] + " mattress: ");
                        String input = scanner.nextLine().trim();
                        try {
                            int count = Integer.parseInt(input);
                            if (count < 0) throw new NumberFormatException();
                            sales[product][month] = count;
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Please enter a non-negative whole number.");
                        }
                    }
                }
                System.out.println();
            }
        }
        new PrintProduct(new Product(PRODUCTS, sales)).printReport();
    }
}
