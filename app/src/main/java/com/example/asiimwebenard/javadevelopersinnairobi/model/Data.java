package com.example.asiimwebenard.javadevelopersinnairobi.model;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("RestResponse")
    private GithubUsersResponse githubUsersResponse;

    public GithubUsersResponse getGithubUsersResponse() {
        return githubUsersResponse;
    }
}