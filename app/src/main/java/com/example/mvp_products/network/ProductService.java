package com.example.mvp_products.network;

import com.example.mvp_products.model.MyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {

    @GET("products")
    Call<MyResponse> getAllProducts();
}
