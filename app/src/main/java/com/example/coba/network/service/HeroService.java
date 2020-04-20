package com.example.coba.network.service;

import android.widget.Toast;

import com.example.coba.domain.Hero;
import com.example.coba.network.api.HeroApi;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroService extends BaseService {

    private static HeroService instance;

    public static HeroService getInstance() {
        if (instance == null) {
            instance = new HeroService();
        }

        return instance;
    }

}
