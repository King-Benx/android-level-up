package com.example.asiimwebenard.javadevelopersinnairobi.presenter;


import com.example.asiimwebenard.javadevelopersinnairobi.model.Data;
import com.example.asiimwebenard.javadevelopersinnairobi.model.GithubUsers;
import com.example.asiimwebenard.javadevelopersinnairobi.service.GithubService;
import com.example.asiimwebenard.javadevelopersinnairobi.views.GithubUserView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter{
    private GithubUserView githubUserView;
    private GithubService githubService;

    public GithubPresenter(GithubUserView githubUserView) {
        this.githubUserView = githubUserView;
        if (this.githubService == null){
            this.githubService = new GithubService();
        }
    }

    public void getAllUsers(){
        githubService
                .githubApi()
                .getAllUsers()
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Data data = response.body();
                        if(data != null && data.getGithubUsersResponse() != null){
                            ArrayList<GithubUsers> results = data.getGithubUsersResponse().getGithubUsers();
                            githubUserView.githubUserReady(results);
                        }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                try{
                    throw new InterruptedException("Failure getting users");
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        });

    }
}