package com.example.coba.network.converter;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by krissadewo on 2/7/17.
 */

public class ResponseDataObjectSolr<T> implements Serializable {

    @SerializedName("response")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDataObjectSolr{" +
                "data=" + data +
                '}';
    }
}

