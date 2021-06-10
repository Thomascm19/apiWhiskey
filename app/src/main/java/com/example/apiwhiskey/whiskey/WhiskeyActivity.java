package com.example.apiwhiskey.whiskey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.apiwhiskey.R;
import com.example.apiwhiskey.whiskey.models.AuctionsInfoRequest;
import com.example.apiwhiskey.whiskey.service.WhiskeyapiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WhiskeyActivity extends AppCompatActivity {
    private static final String TAG = "Whiskey";
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private WhiskeyListAdapter whiskeyListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whiskey);

        recyclerView = findViewById(R.id.recyclerViewWhiskey);
        whiskeyListAdapter = new WhiskeyListAdapter();
        recyclerView.setAdapter(whiskeyListAdapter);
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
        WhiskeyapiService service = retrofit.create(WhiskeyapiService.class);
        Call<List<AuctionsInfoRequest>> auctionsRequestCall = service.getAuctionsInfo();

        auctionsRequestCall.enqueue(new Callback<List<AuctionsInfoRequest>>() {
            @Override
            public void onResponse(Call<List<AuctionsInfoRequest>> call, Response<List<AuctionsInfoRequest>> response) {
                if (response.isSuccessful()) {
                    List<AuctionsInfoRequest> auctionsInfoList = response.body();
                    whiskeyListAdapter.showListOfWhiskey(auctionsInfoList);
                } else {
                    Log.e(TAG, "onResponse: " + response);
                }
            }

            @Override
            public void onFailure(Call<List<AuctionsInfoRequest>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}