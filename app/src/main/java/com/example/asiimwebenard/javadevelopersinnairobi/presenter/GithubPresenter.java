package com.example.asiimwebenard.javadevelopersinnairobi.presenter;

import android.util.Log;

import com.example.asiimwebenard.javadevelopersinnairobi.model.GithubUsers;
import com.example.asiimwebenard.javadevelopersinnairobi.model.GithubUsersResponse;
import com.example.asiimwebenard.javadevelopersinnairobi.service.GithubService;
import com.example.asiimwebenard.javadevelopersinnairobi.views.GithubUserView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter {
    private GithubUserView githubUserView;
    private GithubService githubService;

    public GithubPresenter(GithubUserView githubUserView) {
        this.githubUserView = githubUserView;
        if (this.githubService == null) {
            this.githubService = new GithubService();
        }
    }

    public void getAllUsers() {
        githubService
                .githubApi()
                .getAllUsers()
                .enqueue(new Callback<GithubUsersResponse>() {
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                        GithubUsersResponse githubUsersResponse = response.body();
                        if (githubUsersResponse != null && githubUsersResponse.getGithubUsers() != null) {
                            List<GithubUsers> results = githubUsersResponse.getGithubUsers();
                            githubUserView.githubUserReady(results);
                        }
                    }

                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Failure getting users");
                        } catch (InterruptedException ex) {
                            Log.v("Interupted Exception", ex.toString());
                        }
                    }
                });

    }
}