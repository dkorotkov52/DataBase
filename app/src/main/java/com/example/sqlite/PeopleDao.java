package com.example.sqlite;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

public interface PeopleDao {

    @Query("SELECT * FROM people")
    List<People> getAll();

    @Query("SELECT * FROM people WHERE id = :id")
    People getById(long id);

    @Insert
    void add(People people);

    @Insert
    void remove(People people);

}
