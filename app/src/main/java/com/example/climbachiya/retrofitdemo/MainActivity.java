package com.example.climbachiya.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import adapters.MyRecyclerAdapter;
import interfaces.StackOverflowAPI;
import modals.JsonListItem;
import modals.StackOverflowQuestions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ProgressBar mProgressBar;
    StackOverflowAPI stackOverflowAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUIControls();
        initClassObjects();
    }

    private void initUIControls() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    private void initClassObjects() {

    }

    public void loadData(View view) {

        mProgressBar.setVisibility(View.VISIBLE);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        stackOverflowAPI = retrofit.create(StackOverflowAPI.class);
        Call<StackOverflowQuestions> call = stackOverflowAPI.loadQuestions("android");
        //asynchronous call
        call.enqueue(new Callback<StackOverflowQuestions>() {
            @Override
            public void onResponse(Call<StackOverflowQuestions> call, Response<StackOverflowQuestions> response) {

                int statusCode = response.code();
                Toast.makeText(MainActivity.this, "onResponse :: "+statusCode, Toast.LENGTH_SHORT).show();
                StackOverflowQuestions jsonListItem = response.body();
                //Log.v("response :: ", response.body().items.get(0).getOwners().get(0).getProfile_image());
                List<JsonListItem> result = jsonListItem.getItems();
                //jsonListItem.getItems().get(0).getOwner().getProfile_image();
                //List<Question> result = response.body().getItems();
                //List<Owner> resultOwner = response.body().getOwners();

                if (null != result && result.size() > 0) {

                    Log.v("result Size : ", ""+result.size());
                    MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(MainActivity.this, result);
                    mRecyclerView.setHasFixedSize(true);
                    mRecyclerView.setAdapter(myRecyclerAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());

                } else {
                    Toast.makeText(MainActivity.this, "No records found!", Toast.LENGTH_SHORT).show();
                }
                mProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<StackOverflowQuestions> call, Throwable t) {
                Log.v("onFailure :: " ,t.getMessage());
                Toast.makeText(MainActivity.this, "onFailure :: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
