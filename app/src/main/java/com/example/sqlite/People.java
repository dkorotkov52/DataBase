package com.example.sqlite;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class People {

    @PrimaryKey
    public String name;

    public String email;
    public People(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public People(String name) {
        this.name = name;
    }
}
