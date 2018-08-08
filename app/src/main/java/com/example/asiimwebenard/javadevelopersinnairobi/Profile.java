package com.example.asiimwebenard.javadevelopersinnairobi;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 *  Profile class that defines the user
 */
public class Profile {
    private String username;
    private int profile_photo;
    private String github_link;
    private int repository_number;


    public Profile(String username, int profile_photo, String github_link, int repository_number) {
        this.username = username;
        this.profile_photo = profile_photo;
        this.github_link = github_link;
        this.repository_number = repository_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(int profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getGithub_link() {
        return github_link;
    }

    public void setGithub_link(String github_link) {
        this.github_link = github_link;
    }

    public int getRepository_number() {
        return repository_number;
    }

    public void setRepository_number(int repository_number) {
        this.repository_number = repository_number;
    }

    public static ArrayList<Profile> populate_data() {
        ArrayList<Profile> profiles =new  ArrayList<>();
        profiles.add(new Profile("User 1",R.mipmap.ic_launcher_round,"https://www.github.com/user1",10));
        profiles.add(new Profile("User 2",R.mipmap.ic_launcher_round,"https://www.github.com/user2",20));
        profiles.add(new Profile("User 3",R.mipmap.ic_launcher_round,"https://www.github.com/user3",30));
        profiles.add(new Profile("User 4",R.mipmap.ic_launcher_round,"https://www.github.com/user4",40));
        profiles.add(new Profile("User 5",R.mipmap.ic_launcher_round,"https://www.github.com/user5",20));
        profiles.add(new Profile("User 6",R.mipmap.ic_launcher_round,"https://www.github.com/user6",10));
        profiles.add(new Profile("User 7",R.mipmap.ic_launcher_round,"https://www.github.com/user7",01));
        profiles.add(new Profile("User 8",R.mipmap.ic_launcher_round,"https://www.github.com/user8",30));
        profiles.add(new Profile("User 9",R.mipmap.ic_launcher_round,"https://www.github.com/user9",50));
        profiles.add(new Profile("User 10",R.mipmap.ic_launcher_round,"https://www.github.com/user10",78));
        profiles.add(new Profile("User 11",R.mipmap.ic_launcher_round,"https://www.github.com/user11",24));
        profiles.add(new Profile("User 12",R.mipmap.ic_launcher_round,"https://www.github.com/user12",23));
        profiles.add(new Profile("User 13",R.mipmap.ic_launcher_round,"https://www.github.com/user13",45));
        profiles.add(new Profile("User 14",R.mipmap.ic_launcher_round,"https://www.github.com/user14",65));
        profiles.add(new Profile("User 15",R.mipmap.ic_launcher_round,"https://www.github.com/user15",78));
        profiles.add(new Profile("User 16",R.mipmap.ic_launcher_round,"https://www.github.com/user16",23));
        profiles.add(new Profile("User 17",R.mipmap.ic_launcher_round,"https://www.github.com/user17",2));
        profiles.add(new Profile("User 18",R.mipmap.ic_launcher_round,"https://www.github.com/user18",21));
        profiles.add(new Profile("User 19",R.mipmap.ic_launcher_round,"https://www.github.com/user19",12));
        profiles.add(new Profile("User 20",R.mipmap.ic_launcher_round,"https://www.github.com/user20",14));
        return profiles;
    }

}
