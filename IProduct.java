package com.mattress;

/** Required interface for the mattress sales report. */
public interface IProduct {
    int GetTotalProductsSold();
    double GetAverageProductSold();
    String GetMostPopularProduct();
}
