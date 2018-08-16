package com.example.asiimwebenard.javadevelopersinnairobi.service;
import com.example.asiimwebenard.javadevelopersinnairobi.model.GithubUsersResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubApi {
    @GET("/search/users?q=type:user+language:java+location:nairobi")
    Call<GithubUsersResponse> getAllUsers();
}
