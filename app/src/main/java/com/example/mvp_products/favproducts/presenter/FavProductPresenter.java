package com.example.mvp_products.favproducts.presenter;

import androidx.lifecycle.LiveData;

import com.example.mvp_products.allproducts.presenter.AllProductPresenterInterface;
import com.example.mvp_products.allproducts.view.AllProductViewInterface;
import com.example.mvp_products.db.LocalSource;
import com.example.mvp_products.favproducts.view.FavViewInterface;
import com.example.mvp_products.model.Product;
import com.example.mvp_products.model.RepositoryInterface;

import java.util.List;

public class FavProductPresenter implements FavProductPresenterInterface {

    private FavViewInterface _view;

    private RepositoryInterface _repo;

    public FavProductPresenter(FavViewInterface view , RepositoryInterface repo){
        this._view = view;
        this._repo = repo;

    }
    @Override
    public LiveData<List<Product>> getProducts() {
        return _repo.getAllFavProducts();
    }

    @Override
    public void deleteProduct(Product product) {
        _repo.deleteProduct(product);
    }
}
