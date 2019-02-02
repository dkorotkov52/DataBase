package com.example.sqlite;

import android.arch.persistence.room.Database;

import android.arch.persistence.room.RoomDatabase;

@Database(entities = {People.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract PeopleDao peopleDao();
}
