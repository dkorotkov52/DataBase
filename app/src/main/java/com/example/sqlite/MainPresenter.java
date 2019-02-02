package com.example.sqlite;

import android.app.Presentation;
import android.util.Log;

import java.util.List;

class MainPresenter{
    private MainView view;

    void getPeooples (){
        List<People> peoples;
        peoples = App.getNewInstanse().getDatabase().peopleDao().getAll();
        view.showList(peoples);
    }

    void addPeople(String name, String email){
        Log.e("MyLog", "name " + name + " name " + email);
        App.getNewInstanse().getDatabase().peopleDao().add(new People(name, email));
        view.showToast("Добавлено");
    }

    void removePeople(String name){
        Log.e("MyLog", "remove name " + name);

        view.showToast("Удалено");
    }

    void getPeople(String name){
        Log.e("MyLog", "name " + name);

        view.showToast("Имя: " + name);
    }
}
