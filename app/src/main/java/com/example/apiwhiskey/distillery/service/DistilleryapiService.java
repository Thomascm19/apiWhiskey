package com.example.apiwhiskey.distillery.service;

import com.example.apiwhiskey.distillery.models.DistilleryInfoRequest;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DistilleryapiService {

    @GET("distilleries_info/")
    Call<List<DistilleryInfoRequest>> getDistilleriesInfo();
}
