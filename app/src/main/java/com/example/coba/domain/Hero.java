package com.example.coba.domain;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Hero extends RealmObject {

    private Long id;

    private String name;

    private String realName;

    private String team;

    private String firstAppearance;

    private String createdBy;

    private String publisher;

    private String imageUrl;

    private String bio;
}
