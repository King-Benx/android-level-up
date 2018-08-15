package com.example.asiimwebenard.javadevelopersinnairobi.service;

import com.example.asiimwebenard.javadevelopersinnairobi.model.Data;
import com.example.asiimwebenard.javadevelopersinnairobi.model.GithubUsers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubApi {
    @GET("/search/users?q=type:user+language:java+location:nairobi")
    Call<Data> getAllUsers();
}
