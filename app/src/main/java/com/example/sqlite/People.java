package com.example.sqlite;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class People {

    @PrimaryKey
    public long id;

    public String name;
    public String email;
}
