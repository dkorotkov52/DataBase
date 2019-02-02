package com.example.sqlite;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private MainPresenter presenter;
    private EditText name;
    private EditText email;
    private Button add;
    private Button read;
    private Button remove;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.add);
        read = findViewById(R.id.read);
        remove = findViewById(R.id.remove);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        text = findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
        String name = String.valueOf(this.name.getText());
        String email = String.valueOf(this.email.getText());
        switch (v.getId()) {
            case R.id.add:
                presenter.addPeople(name, email);
                break;
            case R.id.read:
                presenter.getPeople(name);
                break;
            case R.id.remove:
                presenter.removePeople(name, email);
                break;
            case R.id.showPeoples:
                presenter.getPeooples();
                break;
        }
    }

    @Override
    public void showToast(String text) {
        Toast toast = Toast.makeText(getApplicationContext(),
                text, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showList(List<People> peoples) {
        for (int i = 0; i < peoples.size(); i++){
            text.append(peoples.get(i).toString() + "/n");
        }
    }
}