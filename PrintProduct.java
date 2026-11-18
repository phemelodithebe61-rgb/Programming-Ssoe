package com.mattress;

/** Keeps report formatting separate from business calculations. */
public class PrintProduct {
    private final IProduct product;
    public PrintProduct(IProduct product) { this.product = product; }
    public void printTotalProductSales() { System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold()); }
    public void printAverageProductSales() { System.out.printf("AVERAGE PRODUCT SALES: %.0f%n", product.GetAverageProductSold()); }
    public void printMostPopularProduct() { System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct()); }
    public void printReport() {
        System.out.println("\nPRODUCT SALES REPORT - 2026\n");
        System.out.println("****************************************");
        printTotalProductSales();
        printAverageProductSales();
        printMostPopularProduct();
    }
}
