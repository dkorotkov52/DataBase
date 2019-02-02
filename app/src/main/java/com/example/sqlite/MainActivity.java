package com.example.sqlite;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private MainPresenter presenter;
    private EditText name;
    private EditText email;
    private Button add;
    private Button read;
    private Button remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
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

                break;
            case R.id.remove:
                break;
        }
    }

    @Override
    public void showToast(String text) {
        Toast toast = Toast.makeText(getApplicationContext(),
                text, Toast.LENGTH_SHORT);
        toast.show();
    }
}