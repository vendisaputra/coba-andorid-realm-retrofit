package com.example.coba.network.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by krissadewo on 05/01/16.
 */
public class DataWrapperConverterFactory extends Converter.Factory {

    private GsonBuilder gsonBuilder;
    private Gson gson;

    public DataWrapperConverterFactory() {
        super();

        gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ResponseDataList.class, new ResponseDataListDeserializer());
        gsonBuilder.registerTypeAdapter(ResponseDataObject.class, new ResponseDataObjectDeserializer());
        gsonBuilder.registerTypeAdapter(ResponseDataObject.class, new ResponseDataObjectSolrDeserializer());

        gson = new GsonBuilder().create();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(final Type type, Annotation[] annotations, Retrofit retrofit) {
        return (Converter<ResponseBody, Object>) responseBody -> gson.fromJson(responseBody.string(), type);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(final Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return (Converter<Object, RequestBody>) value -> {
            String json = gson.toJson(value, type);

            return RequestBody.create(MediaType.parse("application/json"), json);
        };
    }
}
