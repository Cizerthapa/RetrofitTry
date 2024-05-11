package com.cizer.tryretrofit.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cizer.tryretrofit.ProductViewHolder;
import com.cizer.tryretrofit.R;
import com.cizer.tryretrofit.model.ProductLaptop;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private final ArrayList<ProductLaptop> laptopProducts;

    public PostAdapter(ArrayList<ProductLaptop> laptopProducts) {
        this.laptopProducts = laptopProducts;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductLaptop product = laptopProducts.get(position);
        holder.textViewName.setText(product.getProductName());
        holder.textViewPrice.setText(product.getProductPrice());

        // Load image using Picasso or any other image loading library
        Picasso.get()
                .load(product.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return laptopProducts.size();
    }
}