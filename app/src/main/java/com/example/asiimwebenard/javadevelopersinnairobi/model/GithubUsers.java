package com.example.asiimwebenard.javadevelopersinnairobi.model;

import com.google.gson.annotations.SerializedName;

public class GithubUsers {
    @SerializedName("id")
    private int id;

    @SerializedName("login")
    private String username;

    @SerializedName("html_url")
    private String github_link;

    @SerializedName("repos_url")
    private String repos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGithub_link() {
        return github_link;
    }

    public void setGithub_link(String github_link) {
        this.github_link = github_link;
    }

    public String getRepos() {
        return repos;
    }

    public void setRepos(String repos) {
        this.repos = repos;
    }


}
