package com.example.coba.network.service;

import com.example.coba.network.ProxyApi;
import com.example.coba.network.api.BaseApi;

import java.lang.reflect.Proxy;

public class BaseService {

    protected BaseApi baseApi;

    protected BaseService() {
        baseApi = (BaseApi) Proxy.newProxyInstance(BaseApi.class.getClassLoader(),
                new Class[]{BaseApi.class}, new ProxyApi());
    }
}
