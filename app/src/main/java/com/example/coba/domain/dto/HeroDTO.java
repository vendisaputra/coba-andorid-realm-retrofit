package com.example.coba.domain.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class HeroDTO implements Parcelable, Cloneable {

    private Long id;

    private String name;

    private String realName;

    private String team;

    private String firstAppearance;

    private String createdBy;

    private String publisher;

    private String imageUrl;

    private String bio;

    protected HeroDTO(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
        this.realName = in.readString();
        this.team = in.readString();
        this.firstAppearance = in.readString();
        this.createdBy = in.readString();
        this.publisher = in.readString();
        this.imageUrl = in.readString();
        this.bio = in.readString();
    }

    public static final Creator<HeroDTO> CREATOR = new Creator<HeroDTO>() {
        @Override
        public HeroDTO createFromParcel(Parcel in) {
            return new HeroDTO(in);
        }

        @Override
        public HeroDTO[] newArray(int size) {
            return new HeroDTO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeValue(this.name);
        dest.writeValue(this.realName);
        dest.writeValue(this.team);
        dest.writeValue(this.firstAppearance);
        dest.writeValue(this.createdBy);
        dest.writeValue(this.publisher);
        dest.writeValue(this.imageUrl);
        dest.writeValue(this.bio);
    }
}
