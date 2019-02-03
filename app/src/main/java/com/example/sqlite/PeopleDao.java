package com.example.sqlite;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.lang.ref.SoftReference;
import java.util.List;

import io.reactivex.Single;

@Dao
public interface PeopleDao {

    @Query("SELECT * FROM people")
    Single<List<People>> getAll();

    @Query("SELECT * FROM people WHERE name = :name")
    Single<People> getById(String name);

    @Insert
    void add(People people);

    @Delete
    void remove(People people);

}
