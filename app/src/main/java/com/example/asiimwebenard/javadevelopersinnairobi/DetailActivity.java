package com.example.asiimwebenard.javadevelopersinnairobi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        TextView textView = findViewById(R.id.username);
        TextView repoView = findViewById(R.id.repo_number);
        TextView githubLink = findViewById(R.id.github_link);
        ImageView imageView = findViewById(R.id.profile_photo);
        textView.setText(intent.getStringExtra(RecyclerViewAdapter.USERNAME));
        repoView.setText(""+intent.getIntExtra(RecyclerViewAdapter.REPO_NUMBER,0));
        githubLink.setText(intent.getStringExtra(RecyclerViewAdapter.GITHUB_LINK));
        imageView.setImageResource(intent.getIntExtra(RecyclerViewAdapter.PROFILE_PIC, 0));

    }
}
