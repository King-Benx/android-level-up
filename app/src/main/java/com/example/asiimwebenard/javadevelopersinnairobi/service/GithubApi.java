package com.example.asiimwebenard.javadevelopersinnairobi.service;

import com.example.asiimwebenard.javadevelopersinnairobi.model.GithubUsers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public abstract class GithubApi {
    @GET("/search/users")
    abstract Call<ArrayList<GithubUsers>> getAllUsers();
}
