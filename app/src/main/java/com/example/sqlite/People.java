package com.example.sqlite;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class People {

    @PrimaryKey
    @NonNull
    public String name;

    String email;

//    People(String name, String email) {
//        this.name = name;
//        this.email = email;
//    }
//
//    public People(String name) {
//        this.name = name;
//    }
}
