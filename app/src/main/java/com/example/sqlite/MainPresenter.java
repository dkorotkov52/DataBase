package com.example.sqlite;

import android.app.Presentation;
import android.util.Log;

import java.util.List;
import java.util.Observable;

class MainPresenter{
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    void getPeooples (){
        List<People> peoples;
        peoples = App.getNewInstanse().getDatabase().peopleDao().getAll();
        Log.e("MyLog", String.valueOf(peoples.size()));
        view.showList(peoples);
    }

    void addPeople(String name, String email){
        Log.e("MyLog", "name " + name + " email " + email);
        People people = new People();
        people.name = name;
        people.email = email;
        try {
            App.getNewInstanse().getDatabase().peopleDao().add(people);
        }
        catch (Exception e){

        }
        view.showToast("Добавлено");
    }

    void removePeople(String name, String email){
        People people = new People();
        people.name = name;
        people.email = email;
        Log.e("MyLog", "remove name " + name);

        App.getNewInstanse().getDatabase().peopleDao().remove(people);
        view.showToast("Удалено");
    }

    void getPeople(String name){
        Log.e("MyLog", "name " + name);
        People people = App.getNewInstanse().getDatabase().peopleDao().getById(name);
        view.showToast("Имя: " + people.name + " email " + people.email);
    }
}
