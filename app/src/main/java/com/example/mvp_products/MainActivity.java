package com.example.mvp_products;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvp_products.allproducts.view.AllProductsActivity;
import com.example.mvp_products.favproducts.view.FavProductsActivity;

public class MainActivity extends AppCompatActivity {

    Button allProducts , favProducts , exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allProducts = findViewById(R.id.allProductBtn);
        favProducts = findViewById(R.id.favProductBtn);
        exitBtn = findViewById(R.id.exitBtn);

        allProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AllProductsActivity.class);
                startActivity(intent);
            }
        });

        favProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , FavProductsActivity.class);
                startActivity(intent);
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}