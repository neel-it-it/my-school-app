package com.example.schoolmanagement.helper;

import com.example.schoolmanagement.api.ApiClient;
import com.example.schoolmanagement.api.ApiInterface;

public class Common {
    public static final String isLoggedIn = "isLoggedIn";
    public static final String userId = "userId";
    public static final String userRole = "userRole";
    public static ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
}
