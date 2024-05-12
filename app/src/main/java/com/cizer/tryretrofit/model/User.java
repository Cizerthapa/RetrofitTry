package com.cizer.tryretrofit.model;

import com.google.gson.annotations.SerializedName;

public class User {
        @SerializedName("name")
        private String name1;

        @SerializedName("gender")
        private String gender1;

        @SerializedName("email")
        private String email1;

        @SerializedName("password")
        private String password1;

        public User( String name1,String gender1, String email1, String pass1){
            this.name1 = name1;
            this.email1 = email1;
            this.password1 = pass1;
            this.gender1 = gender1;
        }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getGender1() {
        return gender1;
    }

    public void setGender1(String gender1) {
        this.gender1 = gender1;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
}
