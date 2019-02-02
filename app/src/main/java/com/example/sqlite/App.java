package com.example.sqlite;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {

    public static App newInstanse;

    private AppDataBase database;

    @Override
    public void onCreate() {
        super.onCreate();
        newInstanse = this;
        database = Room.databaseBuilder(this, AppDataBase.class, "database")
                .build();
    }

    public static App getNewInstanse(){
        return newInstanse;
    }

    public AppDataBase getDatabase() {
        return database;
    }
}
