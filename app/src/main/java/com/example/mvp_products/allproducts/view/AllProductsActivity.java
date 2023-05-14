package com.example.mvp_products.allproducts.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvp_products.R;
import com.example.mvp_products.allproducts.presenter.AllProductPresenter;
import com.example.mvp_products.allproducts.presenter.AllProductPresenterInterface;
import com.example.mvp_products.db.ConcreteLocalSource;
import com.example.mvp_products.model.Product;
import com.example.mvp_products.model.Repository;
import com.example.mvp_products.network.ProductClient;

import java.util.ArrayList;
import java.util.List;

public class AllProductsActivity extends AppCompatActivity implements onProductClickListener , AllProductViewInterface{

    RecyclerView recyclerView;
    AllProductsAdapter myAdapter;

    AllProductPresenterInterface allPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);

        allPresenter = new AllProductPresenter(this, Repository.getInstance(ProductClient.getInstance(),
                ConcreteLocalSource.getInstance(this),this));

        recyclerView = findViewById(R.id.allproduct_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new AllProductsAdapter(this , new ArrayList<>() ,this);
        recyclerView.setAdapter(myAdapter);
        allPresenter.getProducts();
    }

    @Override
    public void onClickItem(Product product) {
        addProduct(product);
    }

    @Override
    public void showData(List<Product> products) {
        myAdapter.setValues(products);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void addProduct(Product product) {
        allPresenter.addProduct(product);
    }
}