//package com.cizer.tryretrofit;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.cizer.tryretrofit.model.ProductLaptop;
//import com.cizer.tryretrofit.utilities.ApiCallback;
//import com.cizer.tryretrofit.utilities.ApiClient;
//import com.cizer.tryretrofit.views.adapter.PostAdapter;
//import com.cizer.tryretrofit.views.viewholder.Login;
//import com.cizer.tryretrofit.views.viewholder.Register;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//    private PostAdapter adapter;
//    private ArrayList<ProductLaptop> products = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recycler_v);
//
//        RecyclerView recyclerView = findViewById(R.id.rvPosts);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new PostAdapter(products);
//        recyclerView.setAdapter(adapter);
//
//        ApiClient apiClient = new ApiClient();
//        apiClient.getProducts(new ApiCallback() {
//            @SuppressLint("NotifyDataSetChanged")
//            @Override
//            public void onSuccess(ArrayList<ProductLaptop> productList) {
//                products.clear();
//                products.addAll(productList);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(String message) {
//                // Handle failure
//            }
//        });
//    }
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////        EdgeToEdge.enable(this);
////        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
////            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
////            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
////            return insets;
////        });
////    }
////
////    public void openRegisterActivity(View view) {
////        startActivity(new Intent(MainActivity.this, Register.class));
////    }
////
////    public void openLoginActivity(View view) {
////        startActivity(new Intent(MainActivity.this, Login.class));
////    }
////    public void openProductsPage(View view) {
////        try {
////            startActivity(new Intent(MainActivity.this, ProductViewHolder.class));
////        } catch (Exception e) {
////            e.printStackTrace();
////            // Handle or log the exception
////        }
////    }
//    }
//
