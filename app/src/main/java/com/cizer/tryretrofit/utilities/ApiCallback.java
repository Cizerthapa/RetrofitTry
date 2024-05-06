package com.cizer.tryretrofit.utilities;

import com.cizer.tryretrofit.model.ProductLaptop;

import java.util.ArrayList;

public interface ApiCallback {
    void onSuccess(ArrayList<ProductLaptop> productList);
    void onFailure(String message);
}
