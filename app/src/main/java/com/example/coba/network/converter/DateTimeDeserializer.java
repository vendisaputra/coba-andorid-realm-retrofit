package com.example.coba.network.converter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import id.padipos.android.PadiPosApplication;

/**
 * https://kylewbanks.com/blog/String-Date-Parsing-with-GSON-UTC-Time-Zone
 */

public class DateTimeDeserializer implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
        String date = element.getAsJsonPrimitive().getAsString();

        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            try {
                formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.US);
                return formatter.parse(date);
            }catch (ParseException e1){
                e.printStackTrace();
                e1.printStackTrace();
                return null;
            }

        }
    }
}

