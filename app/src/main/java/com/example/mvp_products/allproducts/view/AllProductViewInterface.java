package com.example.mvp_products.allproducts.view;

import com.example.mvp_products.model.Product;

import java.util.List;

public interface AllProductViewInterface {
    public void showData(List<Product> products);
    public void addProduct(Product product);

}
