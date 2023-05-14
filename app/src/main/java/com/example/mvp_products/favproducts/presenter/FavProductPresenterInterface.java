package com.example.mvp_products.favproducts.presenter;

import androidx.lifecycle.LiveData;

import com.example.mvp_products.model.Product;

import java.util.List;

public interface FavProductPresenterInterface {

    public LiveData<List<Product>> getProducts();
    public void deleteProduct(Product product);
}
