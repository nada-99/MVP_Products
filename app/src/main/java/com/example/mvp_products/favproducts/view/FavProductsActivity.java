package com.example.mvp_products.favproducts.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvp_products.R;
import com.example.mvp_products.allproducts.presenter.AllProductPresenter;
import com.example.mvp_products.allproducts.view.AllProductsAdapter;
import com.example.mvp_products.db.ConcreteLocalSource;
import com.example.mvp_products.favproducts.presenter.FavProductPresenter;
import com.example.mvp_products.favproducts.presenter.FavProductPresenterInterface;
import com.example.mvp_products.model.Product;
import com.example.mvp_products.model.Repository;
import com.example.mvp_products.network.ProductClient;

import java.util.ArrayList;
import java.util.List;

public class FavProductsActivity extends AppCompatActivity implements onFavClickListener , FavViewInterface{

    RecyclerView recyclerView;
    FavProductsAdapter myAdapter;
    FavProductPresenterInterface allPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_products);

        allPresenter = new FavProductPresenter(this, Repository.getInstance(ProductClient.getInstance(),
                ConcreteLocalSource.getInstance(this),this));

        recyclerView = findViewById(R.id.favproduct_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new FavProductsAdapter(this , new ArrayList<>() ,this);
        recyclerView.setAdapter(myAdapter);
        allPresenter.getProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                myAdapter.setValues(products);
                myAdapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void deleteProduct(Product product) {
        deleteProduct(product);
    }

    @Override
    public void onClickItem(Product product) {
        allPresenter.deleteProduct(product);
    }
}