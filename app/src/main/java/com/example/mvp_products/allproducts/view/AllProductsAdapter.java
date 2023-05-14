package com.example.mvp_products.allproducts.view;

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

public class AllProductsAdapter extends RecyclerView.Adapter<AllProductsAdapter.ViewHolder> {

    private final Context context;
    private List<Product> values;

    private onProductClickListener listener;

    public List<Product> getValues() {
        return values;
    }

    public void setValues(List<Product> values) {
        this.values = values;
    }

    public AllProductsAdapter(Context context, List<Product> values , onProductClickListener listener) {
        this.context = context;
        this.values = values;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(recyclerView.getContext());
        View v = layoutInflater.inflate(R.layout.product_row_layout,recyclerView,false);
        ViewHolder vh = new ViewHolder(v);
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

        holder.addButton.setOnClickListener(new View.OnClickListener() {
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
        Button addButton;
        CardView cardView;
        View layout;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            titleTxt = v.findViewById(R.id.titleTextView);
            brandTxt = v.findViewById(R.id.brandTextView);
            productImg = v.findViewById(R.id.productImageView);
            addButton = v.findViewById(R.id.allProductBtn);
            cardView = v.findViewById(R.id.product_row_layout);
        }
    }
}

