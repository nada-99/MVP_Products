package com.example.mvp_products.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvp_products.model.Product;

@Database(entities = {Product.class} , version = 1)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance = null;
    public abstract ProductDao productDao();
    public static synchronized AppDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"products").build();
        }
        return instance;
    }


}
