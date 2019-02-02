package com.example.sqlite;

import java.util.List;

public interface MainView {

    void showToast(String text);

    void showList(List<People> peoples);
}
