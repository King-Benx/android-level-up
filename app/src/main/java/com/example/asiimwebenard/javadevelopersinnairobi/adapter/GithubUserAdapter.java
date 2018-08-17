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
        view =  layoutInflater.inflate(R.layout.list_item_structure,viewGroup,false);
        return new GithubUserAdapter.AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubUserAdapter.AppViewHolder appViewHolder, final int position) {
        Picasso.get().load(githubUsers.get(position).getAvatarUrl()).transform(new CropCircleTransformation()).into(appViewHolder.imageView);
        appViewHolder.textView.setText(githubUsers.get(position).getUsername());
        appViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(USERNAME, githubUsers.get(position).getUsername());
                intent.putExtra(GITHUB_LINK, githubUsers.get(position).getGithubLink());
                intent.putExtra(PROFILE_PIC, githubUsers.get(position).getAvatarUrl());
                intent.putExtra(REPO_NUMBER, randomWithRange(10,50));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return githubUsers.size();
    }

    public static class AppViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;

        LinearLayout linearLayout;
        public AppViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.profile_image);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.item_view_id);
        }
    }



    protected int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (new Random().nextInt(range)) + min;
    }
}
