package com.example.coba.network;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyApi implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null; //Validate token if valid or not;
    }
}
