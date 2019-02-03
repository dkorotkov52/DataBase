package com.example.sqlite;

import android.app.Presentation;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;
import java.util.Observable;

class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    void getPeooples() {
        List<People> peoples;
        peoples = App.getNewInstanse().getDatabase().peopleDao().getAll();
        view.showList(peoples);
    }

    void addPeople(String name, String email) {
        Log.e("MyLog", "name " + name + " email " + email);
        People people = new People();
        people.name = name;
        people.email = email;
        try {
            App.getNewInstanse().getDatabase().peopleDao().add(people);
        } catch (Exception e) {
            view.showToast("Не удалось");
        }
        view.showToast("Добавлено");
    }

    void removePeople(String name, String email) {
        People people = new People();
        people.name = name;
        people.email = email;
        Log.e("MyLog", "remove name " + name);
        try {
            App.getNewInstanse().getDatabase().peopleDao().remove(people);
        } catch (Exception e) {
            view.showToast("Не удалось");
        }
        view.showToast("Удалено");
    }

    void getPeople(String name) {
        Log.e("MyLog", "name " + name);
        try {
            People people = App.getNewInstanse().getDatabase().peopleDao().getById(name);
            view.showToast("Имя: " + people.name + " email " + people.email);
        } catch (Exception e) {
            view.showToast("Не удалось");
        }
    }

    public void allDelete() {
        List<People> peoples;
        peoples = App.getNewInstanse().getDatabase().peopleDao().getAll();
        for (int i = 0; i < peoples.size(); i++) {
            try {
            App.getNewInstanse().getDatabase().peopleDao().remove(peoples.get(i));
            }
            catch (Exception e){
                view.showToast("Не удалось");
            }
        }
        view.showToast("Почистил БД");
    }
}
