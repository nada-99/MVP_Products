package com.example.mvp_products.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import com.example.mvp_products.db.LocalSource;
import com.example.mvp_products.network.NetworkDelegate;
import com.example.mvp_products.network.RemoteSource;

import java.util.List;

public class Repository implements RepositoryInterface{

    private Context context;
    RemoteSource remoteSource;
    LocalSource localSource;
    private static Repository repository = null;

    public static Repository getInstance(RemoteSource remoteSource, LocalSource localSource, Context context){
        if(repository == null){
            repository = new Repository(remoteSource , localSource , context);
        }
        return repository;
    }

    public Repository(RemoteSource remoteSource, LocalSource localSource ,Context context){
        this.remoteSource = remoteSource;
        this.localSource = localSource;
        this.context = context;
    }


    @Override
    public void getAllProducts(NetworkDelegate networkDelegate) {
        remoteSource.enqueueCall(networkDelegate);
    }

    @Override
    public void insetProduct(Product product) {
        localSource.insertProduct(product);
    }

    @Override
    public LiveData<List<Product>> getAllFavProducts() {
        return localSource.getAllFavProducts();
    }

    @Override
    public void deleteProduct(Product product) {
        localSource.deleteProduct(product);
    }
}

