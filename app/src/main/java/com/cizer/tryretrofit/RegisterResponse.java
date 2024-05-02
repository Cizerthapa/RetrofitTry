package com.cizer.tryretrofit;

public class RegisterResponse {
    private String errorcode;
    private String message;

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Method to get the error message
    public String getError() {
        return errorcode;
    }

    // Method to get the status code (assuming status code is an int)
    public int getStatus() {
        try {
            return Integer.parseInt(errorcode); // Assuming errorcode represents the status code
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1; // Default value for status code
        }
    }
}
