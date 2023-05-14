package com.example.mvp_products.network;

import com.example.mvp_products.model.Product;

import java.util.List;

public interface NetworkDelegate {
    void onSuccessResult(List<Product> productList);
    void onFailureResult(String errorMsg);
}
