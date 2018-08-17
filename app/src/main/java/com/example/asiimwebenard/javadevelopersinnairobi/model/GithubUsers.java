package com.example.asiimwebenard.javadevelopersinnairobi.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GithubUsers implements Parcelable {

    public static final Creator<GithubUsers> CREATOR = new Creator<GithubUsers>() {

        public GithubUsers createFromParcel(Parcel in) {
            return new GithubUsers(in);
        }

        public GithubUsers[] newArray(int size) {
            return new GithubUsers[size];
        }
    };

    @SerializedName("id")
    private int id;

    @SerializedName("login")
    private String username;

    @SerializedName("html_url")
    private String githubLink;

    @SerializedName("repos_url")
    private String repos;

    @SerializedName("avatar_url")
    private String avatarUrl;

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    private GithubUsers(Parcel in) {
        this.id = in.readInt();
        this.username = in.readString();
        this.avatarUrl = in.readString();

        this.githubLink = in.readString();
        this.repos = in.readString();

    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

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

    public String getRepos() {
        return repos;
    }

    public void setRepos(String repos) {
        this.repos = repos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(this.id);
        out.writeString(this.username);
        out.writeString(this.avatarUrl);
        out.writeString(this.repos);
        out.writeString(this.githubLink);
    }

}
