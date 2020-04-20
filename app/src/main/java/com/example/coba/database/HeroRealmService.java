package com.example.coba.database;

import androidx.annotation.NonNull;

import com.example.coba.domain.Hero;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;

public class HeroRealmService {

    private static HeroRealmService sInstance;

    public static  synchronized HeroRealmService getInstance(){
        if (sInstance == null){
            sInstance = new HeroRealmService();
        }

        return sInstance;
    }

    public Hero findById(Realm realm, long heroId){
        Hero hero = realm.where(Hero.class)
                .equalTo("id", heroId)
                .findFirst();

        if (hero != null){
            return realm.copyFromRealm(hero);
        }

        return null;
    }

    public List<Hero> searchHero(Realm realm, String name) {
        return realm.copyFromRealm(realm.where(Hero.class)
                .contains("name", name, Case.INSENSITIVE)
                .findAll());
    }

    public void insertBatch(@NonNull Realm realm, final List<Hero> heroes, DatabaseCallback.OnInsertBatchCallback batchCallback){
       realm.executeTransactionAsync(paramRealm -> {
           paramRealm.insertOrUpdate(heroes);
       }, batchCallback::onSuccess);
    }

    public void deleteFromRealm(Realm realm) {
        //tambahan method deletefromrealm
        realm.executeTransactionAsync(paramRealm -> {
            RealmResults<Hero> results = paramRealm.where(Hero.class).findAll();
            results.deleteAllFromRealm();
        });
    }
}
