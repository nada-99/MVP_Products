package com.example.mvp_products.favproducts.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvp_products.R;
import com.example.mvp_products.model.Product;

import java.util.List;

public class FavProductsAdapter extends RecyclerView.Adapter<FavProductsAdapter.ViewHolder> {

    private final Context context;
    private List<Product> values;

    private onFavClickListener listener;

    public List<Product> getValues() {
        return values;
    }

    public FavProductsAdapter(Context context){

        this.context = context;
    }

    public void setValues(List<Product> values) {
        this.values = values;
    }

    public FavProductsAdapter(Context context, List<Product> values , onFavClickListener listener) {
        this.context = context;
        this.values = values;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(recyclerView.getContext());
        View v = layoutInflater.inflate(R.layout.fav_row_layout,recyclerView,false);
        FavProductsAdapter.ViewHolder vh = new FavProductsAdapter.ViewHolder(v);
        Log.i("tag","=====onCreateViewHolder=======");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = values.get(position);
        holder.titleTxt.setText(values.get(position).getTitle());
        holder.brandTxt.setText(values.get(position).getBrand());
        Glide.with(context)
                .load(values.get(position).getThumbnail())
                .into(holder.productImg);

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickItem(product);
            }
        });

        Log.i("tag","=====onBindViewHolder=======");

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTxt , brandTxt;
        ImageView productImg;
        Button deleteButton;
        CardView cardView;
        View layout;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            titleTxt = v.findViewById(R.id.titleTextView);
            brandTxt = v.findViewById(R.id.brandTextView);
            productImg = v.findViewById(R.id.productImageView);
            deleteButton = v.findViewById(R.id.deleteProductBtn);
            cardView = v.findViewById(R.id.product_row_layout);
        }
    }
}

