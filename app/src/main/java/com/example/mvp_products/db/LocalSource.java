package com.example.mvp_products.db;

import androidx.lifecycle.LiveData;

import com.example.mvp_products.model.Product;

import java.util.List;

public interface LocalSource {

    void insertProduct(Product product);
    void deleteProduct(Product product);
    LiveData<List<Product>> getAllFavProducts();
}
