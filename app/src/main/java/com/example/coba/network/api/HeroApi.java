package com.example.coba.network.api;

import com.example.coba.domain.Hero;
import com.example.coba.domain.dto.HeroDTO;
import com.example.coba.network.converter.ResponseDataList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface HeroApi {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> doFindHero();
}
