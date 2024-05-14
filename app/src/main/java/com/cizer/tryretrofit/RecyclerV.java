package com.cizer.tryretrofit;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cizer.tryretrofit.model.ProductLaptop;
import com.cizer.tryretrofit.utilities.ApiCallback;
import com.cizer.tryretrofit.utilities.ApiClient;
import com.cizer.tryretrofit.views.adapter.PostAdapter;

import java.util.ArrayList;

public class RecyclerV extends AppCompatActivity {

    private PostAdapter laptopadapter;
    private ArrayList<ProductLaptop> laptops = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_v);

        RecyclerView recyclerView = findViewById(R.id.rvPosts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        laptopadapter = new PostAdapter(laptops);
        recyclerView.setAdapter(laptopadapter);

        ApiClient apiClient = new ApiClient();
        apiClient.getProducts(new ApiCallback() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onComplete(ArrayList<ProductLaptop> productList) {
                laptops.clear();
                laptops.addAll(productList);
                laptopadapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String message) {
                // Handle failure
            }
        });
    }
}