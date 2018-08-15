package com.example.asiimwebenard.javadevelopersinnairobi;

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

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.AppViewHolder> {
    public static final String USERNAME = "com.example.asiimwebenard.javadevelopersinnairobi.USERNAME";
    public static final String GITHUB_LINK = "com.example.asiimwebenard.javadevelopersinnairobi.GITHUB_LINK";
    public static final String PROFILE_PIC = "com.example.asiimwebenard.javadevelopersinnairobi.PROFILE_PIC";
    public static final String REPO_NUMBER = "com.example.asiimwebenard.javadevelopersinnairobi.REPO_NUMBER";

    private Context context;
    private ArrayList<Profile> profiles;

    public RecyclerViewAdapter(Context context, ArrayList<Profile> profiles) {
        this.context = context;
        this.profiles = profiles;
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view =  layoutInflater.inflate(R.layout.list_item_structure,viewGroup,false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder appViewHolder, final int position) {
        appViewHolder.textView.setText(profiles.get(position).getUsername());
        appViewHolder.imageView.setImageResource(profiles.get(position).getProfile_photo());
        appViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(USERNAME, profiles.get(position).getUsername());
                intent.putExtra(GITHUB_LINK, profiles.get(position).getGithub_link());
                intent.putExtra(PROFILE_PIC, profiles.get(position).getProfile_photo());
                intent.putExtra(REPO_NUMBER, profiles.get(position).getRepository_number());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return profiles.size();
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
}