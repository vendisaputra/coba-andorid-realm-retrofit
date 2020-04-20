package com.example.coba;

import android.app.Application;

import com.example.coba.database.CobaRealmMigration;
import java.security.SecureRandom;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    private void iniRealmConfiguration() {

        byte[] key = new byte[64];
        new SecureRandom().nextBytes(key);

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("coba.realm")
                .schemaVersion(0) // Must be increment when the schema changes
                .migration(new CobaRealmMigration()) // Migration to run instead of throwing an exception
                /*.encryptionKey(key)*/
                .build();

        Realm.setDefaultConfiguration(config);
    }
}
