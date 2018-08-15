package com.example.asiimwebenard.javadevelopersinnairobi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asiimwebenard.javadevelopersinnairobi.adapter.GithubUserAdapter;
import com.example.asiimwebenard.javadevelopersinnairobi.views.CropCircleTransformation;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent;
        intent = getIntent();
        TextView textView = findViewById(R.id.username);
        TextView repoView = findViewById(R.id.repo_number);
        TextView githubLink = findViewById(R.id.github_link);
        ImageView imageView = findViewById(R.id.profile_photo);

        final String username = intent.getStringExtra(GithubUserAdapter.USERNAME);
        textView.setText(username);
        repoView.setText(intent.getStringExtra(GithubUserAdapter.REPO_NUMBER));
        final String githubUrl = intent.getStringExtra(GithubUserAdapter.GITHUB_LINK);
        githubLink.setText(githubUrl);
        Picasso.get().load(intent.getStringExtra(GithubUserAdapter.PROFILE_PIC)).transform(new CropCircleTransformation()).into(imageView);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer " + "@" + username + " " + githubUrl);
                startActivity(Intent.createChooser(intent, "Share developer " + "@" + username + " profile"));
            }
        });

    }
}