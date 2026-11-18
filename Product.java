package com.mattress;

import java.util.Arrays;

/** Calculates report statistics from a product-name array and monthly sales matrix. */
public class Product implements IProduct {
    private final String[] productNames;
    private final int[][] monthlySales;

    public Product(String[] productNames, int[][] monthlySales) {
        if (productNames == null || monthlySales == null || productNames.length == 0 || productNames.length != monthlySales.length) {
            throw new IllegalArgumentException("Provide matching non-empty product and sales arrays.");
        }
        this.productNames = Arrays.copyOf(productNames, productNames.length);
        this.monthlySales = new int[monthlySales.length][];
        for (int i = 0; i < monthlySales.length; i++) {
            if (this.productNames[i] == null || this.productNames[i].trim().isEmpty() || monthlySales[i] == null || monthlySales[i].length != 3) {
                throw new IllegalArgumentException("Each named product must have exactly three monthly sales figures.");
            }
            this.monthlySales[i] = Arrays.copyOf(monthlySales[i], 3);
            for (int amount : this.monthlySales[i]) {
                if (amount < 0) throw new IllegalArgumentException("Sales cannot be negative.");
            }
        }
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] months : monthlySales) for (int count : months) total = Math.addExact(total, count);
        return total;
    }

    /** Average sales per product per month, matching the assignment example (153 / 9 = 17). */
    @Override
    public double GetAverageProductSold() {
        return (double) GetTotalProductsSold() / (productNames.length * 3);
    }

    @Override
    public String GetMostPopularProduct() {
        int bestIndex = 0;
        int bestTotal = -1;
        for (int i = 0; i < monthlySales.length; i++) {
            int total = 0;
            for (int amount : monthlySales[i]) total += amount;
            if (total > bestTotal) { bestTotal = total; bestIndex = i; }
        }
        // The sample screenshot shows the largest single-month figure in parentheses.
        int peakMonth = Arrays.stream(monthlySales[bestIndex]).max().orElse(0);
        return productNames[bestIndex] + "(" + peakMonth + ")";
    }
}
