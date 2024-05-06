package com.cizer.tryretrofit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ]#} factory method to
 * create an instance of this fragment.
 */
public class ProductViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewName;
    public TextView textViewPrice;
    public ImageView imgView;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        imgView = itemView.findViewById(R.id.imageView);
    }
}