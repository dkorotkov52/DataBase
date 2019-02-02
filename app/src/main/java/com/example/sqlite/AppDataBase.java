package com.example.sqlite;

import android.arch.persistence.room.Database;

@Database(entities = {People.class}, version = 1)
public abstract class AppDataBase {
    public abstract PeopleDao peopleDao();
}
