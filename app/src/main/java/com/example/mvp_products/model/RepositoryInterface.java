package com.example.mvp_products.model;

import androidx.lifecycle.LiveData;

import com.example.mvp_products.network.NetworkDelegate;

import java.util.List;

public interface RepositoryInterface {

    public void getAllProducts(NetworkDelegate networkDelegate);
    public void insetProduct(Product product);

    public LiveData<List<Product>> getAllFavProducts();
    public void deleteProduct(Product product);


}
