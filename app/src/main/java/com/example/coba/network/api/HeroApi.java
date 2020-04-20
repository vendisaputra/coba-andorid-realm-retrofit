package com.example.coba.network.api;

import com.example.coba.network.converter.ResponseDataList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroApi {

    @GET('marvel')
    Call<ResponseDataList>
}
