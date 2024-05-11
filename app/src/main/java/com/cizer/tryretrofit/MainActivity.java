package com.cizer.tryretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cizer.tryretrofit.model.ProductLaptop;
import com.cizer.tryretrofit.utilities.ApiCallback;
import com.cizer.tryretrofit.utilities.ApiClient;
import com.cizer.tryretrofit.views.adapter.PostAdapter;
import com.cizer.tryretrofit.views.viewholder.Login;
import com.cizer.tryretrofit.views.viewholder.Register;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PostAdapter adapter;
    private ArrayList<ProductLaptop> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_v);

        // Initialize Firebase Cloud Messaging
        FirebaseMessaging.getInstance().subscribeToTopic("all");

        RecyclerView recyclerView = findViewById(R.id.rvPosts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter(products);
        recyclerView.setAdapter(adapter);

        ApiClient apiClient = new ApiClient();
        apiClient.getProducts(new ApiCallback() {
            @Override
            public void onSuccess(ArrayList<ProductLaptop> productList) {
                products.clear();
                products.addAll(productList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String message) {
                // Handle failure
            }
        });
    }

    // Handle FCM message received
    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getExtras() != null && intent.getExtras().containsKey("data")) {
            String data = intent.getStringExtra("data");
            Log.d("FCM", "Received data: " + data);
            // Process the received data as needed
        }
    }

    //navigate to another activity
    public void openRegisterActivity(View view) {
        startActivity(new Intent(MainActivity.this, Register.class));
    }

    public void openLoginActivity(View view) {
        startActivity(new Intent(MainActivity.this, Login.class));
    }
}
