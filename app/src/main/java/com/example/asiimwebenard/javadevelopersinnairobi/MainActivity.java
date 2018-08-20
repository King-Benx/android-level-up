package com.example.asiimwebenard.javadevelopersinnairobi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.asiimwebenard.javadevelopersinnairobi.adapter.GithubUserAdapter;
import com.example.asiimwebenard.javadevelopersinnairobi.model.GithubUsers;
import com.example.asiimwebenard.javadevelopersinnairobi.presenter.GithubPresenter;
import com.example.asiimwebenard.javadevelopersinnairobi.views.GithubUserView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements GithubUserView {

    public static final String LIST_STATE_KEY = "recycler_list_state";
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    Parcelable listState = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this, 2);
        final GithubPresenter githubPresenter = new GithubPresenter(this);
        githubPresenter.getAllUsers();
        final SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Fetching data from the API");
                progressDialog.setMessage("Loading Github Users... ");
                progressDialog.setMax(100);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();
                progressDialog.setCancelable(false);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            while (progressDialog.getProgress() <= progressDialog.getMax()) {
                                Thread.sleep(200);
                                progressDialog.incrementProgressBy(2);
                                if (progressDialog.getProgress() == progressDialog.getMax()) {
                                    progressDialog.dismiss();
                                }
                            }

                        } catch (Exception e) {
                            Log.v("Exception", e.toString());
                        }
                    }
                }).start();
                githubPresenter.getAllUsers();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putParcelable(LIST_STATE_KEY, listState);
    }

    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        if (state != null)
            listState = state.getParcelable(LIST_STATE_KEY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (listState != null) {
            layoutManager.onRestoreInstanceState(listState);
        }
    }

    @Override
    public void githubUserReady(List<GithubUsers> githubUsers) {
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new GithubUserAdapter(this, githubUsers);
        recyclerView.setAdapter(adapter);
    }

}
