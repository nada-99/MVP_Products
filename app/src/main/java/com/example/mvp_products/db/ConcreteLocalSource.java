package com.example.mvp_products.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mvp_products.model.Product;

import java.util.List;

public class ConcreteLocalSource implements LocalSource{

    private ProductDao dao;
    private static ConcreteLocalSource localSource = null;
    private LiveData<List<Product>> storedProducts;

    private ConcreteLocalSource(Context context){
        AppDataBase appDataBase = AppDataBase.getInstance(context.getApplicationContext());
        dao = appDataBase.productDao();
        storedProducts = dao.getAllProducts();
    }

    public static ConcreteLocalSource getInstance(Context context){
        if(localSource == null){
            localSource = new ConcreteLocalSource(context);
        }
        return localSource;
    }


    @Override
    public void insertProduct(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertProduct(product);
            }
        }).start();

    }

    @Override
    public void deleteProduct(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteProduct(product);
            }
        }).start();

    }

    @Override
    public LiveData<List<Product>> getAllFavProducts() {
        return storedProducts;
    }
}
