package com.example.asiimwebenard.javadevelopersinnairobi.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubService {

    private Retrofit retrofit = null;
    public GithubApi githubApi() {
        final String BASE_URL = "https://api.github.com";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(GithubApi.class);
    }
}

