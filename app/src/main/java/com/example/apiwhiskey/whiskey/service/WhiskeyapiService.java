package com.example.apiwhiskey.whiskey.service;

import com.example.apiwhiskey.whiskey.models.AuctionsInfoRequest;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WhiskeyapiService {

    @GET("auctions_info")
    Call<List<AuctionsInfoRequest>> getAuctionsInfo();
}
