package com.example.coba.network.converter;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by krissadewo on 2/7/17.
 */

@Getter
@Setter
public class ResponseDataObject<T> implements Parcelable {

    @SerializedName("data")
    private T data;

    @SerializedName("status")
    private String status;

    @SerializedName("menu")
    private List<String> menu;

    protected ResponseDataObject(Parcel in) {
        status = in.readString();
    }

    public static final Creator<ResponseDataObject> CREATOR = new Creator<ResponseDataObject>() {
        @Override
        public ResponseDataObject createFromParcel(Parcel in) {
            return new ResponseDataObject(in);
        }

        @Override
        public ResponseDataObject[] newArray(int size) {
            return new ResponseDataObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
    }
}

