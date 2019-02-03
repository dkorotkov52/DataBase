package com.example.sqlite;

import android.annotation.SuppressLint;
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
        App.getNewInstanse().getDatabase().peopleDao().getAll().subscribe(this::onGetPeople, this::onError);
    }

    private void onError(Throwable throwable) {
        view.showToast("ERROR");
        Log.e("MyLog", throwable.getMessage());
    }

    private void onGetPeople(List<People> peoples) {
        view.showList(peoples);
    }

    void addPeople(String name, String email) {
        Log.e("MyLog", "name " + name + " email " + email);
        People people = new People();
        people.name = name;
        people.email = email;
        App.getNewInstanse().getDatabase().peopleDao().add(people).subscribe(this::onAddPeople, this::onError);
    }

    private void onAddPeople(Void aVoid) {
        view.showToast("Добавлено");
    }

    void removePeople(String name, String email) {
        People people = new People();
        people.name = name;
        people.email = email;
        App.getNewInstanse().getDatabase().peopleDao().remove(people).subscribe(this::onRemovePeople, this::onError);
    }

    private void onRemovePeople(Void aVoid) {
        view.showToast("Удалено");
    }

    void getPeople(String name) {
        App.getNewInstanse().getDatabase().peopleDao().getById(name).subscribe(this::showPeople, this::onError);
    }

    private void showPeople(People people) {
        view.showToast(people.name + " " + people.email);
    }

    public void allDelete() {
        App.getNewInstanse().getDatabase().peopleDao().getAll().subscribe(this::onPeopleForDelete, this::onError);
    }

    private void onPeopleForDelete(List<People> peoples) {
        for (int i = 0; i < peoples.size(); i++) {
            App.getNewInstanse().getDatabase().peopleDao().remove(peoples.get(i)).subscribe(this::onRemovePeople, this::onError);
        }
        view.showToast("Почистил БД");
    }
}
