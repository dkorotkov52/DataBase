package com.example.sqlite;

import android.app.Presentation;
import android.util.Log;

public class MainPresenter{
    private MainView view;

    public void addPeople(String name, String email){
        long id = generateId();
        Log.e("MyLog", id + " name " + name + " name " + email);
        App.getNewInstanse().getDatabase().peopleDao().add(new People(id, name, email));
        view.showToast("Добавлено");
    }

    private long generateId(){
        return (long) (Math.random() * 9999);
    }
}
