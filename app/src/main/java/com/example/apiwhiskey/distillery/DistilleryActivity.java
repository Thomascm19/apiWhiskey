package com.example.apiwhiskey.distillery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.apiwhiskey.R;
import com.example.apiwhiskey.distillery.models.DistilleryInfoRequest;
import com.example.apiwhiskey.distillery.service.DistilleryapiService;
import com.example.apiwhiskey.whiskey.WhiskeyListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DistilleryActivity extends AppCompatActivity {
    private static final String TAG = "Distillery";
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private DistilleryListAdapter distilleryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distillery);
        recyclerView = findViewById(R.id.recyclerViewDistillery);
        distilleryListAdapter = new DistilleryListAdapter();
        recyclerView.setAdapter(distilleryListAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://whiskyhunter.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getInfo();
    }

    private void getInfo() {
        DistilleryapiService service = retrofit.create(DistilleryapiService.class);
        Call<List<DistilleryInfoRequest>> distilleryInfoRequestCall = service.getDistilleriesInfo();

        distilleryInfoRequestCall.enqueue(new Callback<List<DistilleryInfoRequest>>() {
            @Override
            public void onResponse(Call<List<DistilleryInfoRequest>> call, Response<List<DistilleryInfoRequest>> response) {
                if (response.isSuccessful()) {
                    List<DistilleryInfoRequest> distilleryInfoList = response.body();
                    distilleryListAdapter.showListOfDistillery(distilleryInfoList);
                } else {
                    Log.e(TAG, "onResponse: " + response);
                }
            }

            @Override
            public void onFailure(Call<List<DistilleryInfoRequest>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}