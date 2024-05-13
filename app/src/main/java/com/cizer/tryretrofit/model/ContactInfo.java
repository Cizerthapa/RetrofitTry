package com.cizer.tryretrofit.model;

import com.google.gson.annotations.SerializedName;

public class ContactInfo {
    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("message")
    private String message;

    // Constructor
    public ContactInfo(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

