package com.example.coba.database;

import java.util.List;

public interface DatabaseCallback {
    public interface OnListCallback<T> {

        void onRealmSuccess(List<T> results);
    }

    public interface OnObjectCallback<T> {

        void onRealmSuccess(T object);
    }

    public interface OnInsertBatchCallback {

        void onSuccess();
    }
}
