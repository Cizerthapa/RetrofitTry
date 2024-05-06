package com.cizer.tryretrofit.model;

import com.google.gson.annotations.SerializedName;

public class User {
        @SerializedName("full_name")
        private String fullName;

        @SerializedName("user_name")
        private String userName;

        @SerializedName("email")
        private String email;

        @SerializedName("password")
        private String password;

        public User(String fullName, String userName, String email, String password) {
            this.fullName = fullName;
            this.userName = userName;
            this.email = email;
            this.password = password;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
}
