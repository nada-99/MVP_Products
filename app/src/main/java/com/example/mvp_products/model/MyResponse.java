package com.example.mvp_products.model;

import java.util.List;

public class MyResponse {
    List<Product> products;
    int total , limit , skip;

    public MyResponse(List<Product> products, int total, int limit, int skip) {
        this.products = products;
        this.total = total;
        this.limit = limit;
        this.skip = skip;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }
}
