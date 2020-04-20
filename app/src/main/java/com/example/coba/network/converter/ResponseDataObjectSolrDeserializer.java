package com.example.coba.network.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by krissadewo on 2/7/17.
 */
public class ResponseDataObjectSolrDeserializer implements JsonDeserializer<ResponseDataObject<Object>> {

    @Override
    public ResponseDataObject<Object> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new GsonBuilder().create();

        return gson.fromJson(json, typeOfT);
    }
}
