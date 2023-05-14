package com.example.mvp_products.network;

import android.util.Log;

import com.example.mvp_products.model.MyResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductClient implements RemoteSource{

    private static final String BASE_URL= "https://dummyjson.com/";

    private static ProductClient productClient;

    private ProductClient(){}

    public static ProductClient getInstance(){
        if(productClient == null){
            productClient = new ProductClient();
        }
        return productClient;
    }

    @Override
    public void enqueueCall(NetworkDelegate networkDelegate) {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ProductService productService = retrofit.create(ProductService.class);
        Call<MyResponse> products = productService.getAllProducts();
        products.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if(response.isSuccessful() && response != null){
                    networkDelegate.onSuccessResult(response.body().getProducts());
                    Log.i("tag", "List Size: " + response.body().getProducts().size());
                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });
    }
}

