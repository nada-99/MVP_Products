package com.example.mvp_products.allproducts.presenter;

import android.view.View;

import com.example.mvp_products.allproducts.view.AllProductViewInterface;
import com.example.mvp_products.model.Product;
import com.example.mvp_products.model.RepositoryInterface;
import com.example.mvp_products.network.NetworkDelegate;

import java.util.List;

public class AllProductPresenter implements AllProductPresenterInterface , NetworkDelegate {

    private AllProductViewInterface _view;
    private RepositoryInterface _repo;


    public AllProductPresenter(AllProductViewInterface view , RepositoryInterface repo){
        this._view = view;
        this._repo = repo;
    }

    @Override
    public void onSuccessResult(List<Product> productList) {
        _view.showData(productList);
    }


    @Override
    public void getProducts() {
        _repo.getAllProducts(this);
    }

    @Override
    public void addProduct(Product product) {
        _repo.insetProduct(product);
    }

    @Override
    public void onFailureResult(String errorMsg) {
    }
}
