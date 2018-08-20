package com.example.asiimwebenard.javadevelopersinnairobi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asiimwebenard.javadevelopersinnairobi.DetailActivity;
import com.example.asiimwebenard.javadevelopersinnairobi.R;
import com.example.asiimwebenard.javadevelopersinnairobi.model.GithubUsers;
import com.example.asiimwebenard.javadevelopersinnairobi.views.CropCircleTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserAdapter.AppViewHolder> {
    public static final String USERNAME = "com.example.asiimwebenard.javadevelopersinnairobi.adapter.USERNAME";
    public static final String GITHUB_LINK = "com.example.asiimwebenard.javadevelopersinnairobi.adapter.GITHUB_LINK";
    public static final String PROFILE_PIC = "com.example.asiimwebenard.javadevelopersinnairobi.adapter.PROFILE_PIC";
    public static final String REPO_NUMBER = "com.example.asiimwebenard.javadevelopersinnairobi.adapter.REPO_NUMBER";

    private Context context;
    private List<GithubUsers> githubUsers;

    public GithubUserAdapter(Context context, List<GithubUsers> githubUsers) {
        this.context = context;
        this.githubUsers = githubUsers;
    }

    @NonNull
    @Override
    public GithubUserAdapter.AppViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.list_item_structure, viewGroup, false);
        return new GithubUserAdapter.AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GithubUserAdapter.AppViewHolder appViewHolder, int position) {
        Picasso.get().load(githubUsers.get(position).getAvatarUrl()).transform(new CropCircleTransformation()).into(appViewHolder.imageView);
        appViewHolder.textView.setText(githubUsers.get(position).getUsername());
        appViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(USERNAME, githubUsers.get(appViewHolder.getAdapterPosition()).getUsername());
                intent.putExtra(GITHUB_LINK, githubUsers.get(appViewHolder.getAdapterPosition()).getGithubLink());
                intent.putExtra(PROFILE_PIC, githubUsers.get(appViewHolder.getAdapterPosition()).getAvatarUrl());
                intent.putExtra(REPO_NUMBER, randomWithRange());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return githubUsers.size();
    }

    static class AppViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        LinearLayout linearLayout;

        AppViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.profile_image);
            linearLayout = itemView.findViewById(R.id.item_view_id);
        }
    }


    private String randomWithRange() {
        int range = (50 - 10) + 1;
        return "" + ((new Random().nextInt(range)) + 10);
    }
}
