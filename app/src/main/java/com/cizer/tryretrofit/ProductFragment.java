package com.cizer.tryretrofit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cizer.tryretrofit.model.ProductLaptop;
import com.cizer.tryretrofit.utilities.ApiCallback;
import com.cizer.tryretrofit.utilities.ApiClient;
import com.cizer.tryretrofit.views.adapter.PostAdapter;

import java.util.ArrayList;

public class ProductFragment extends Fragment {

        private RecyclerView recyclerView;
        private PostAdapter adapter;
        private ArrayList<ProductLaptop> products = new ArrayList<>();

        public ProductFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_recycler_v, container, false);

            recyclerView = view.findViewById(R.id.rvPosts);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new PostAdapter(products);
            recyclerView.setAdapter(adapter);

            // Fetch products from API
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

            return view;
        }
}
