package com.example.sqlite;

import android.arch.persistence.room.Room;
import android.os.Build;
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
    private Button showPeoples;
    private Button allDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        initView();
    }

    private void initView() {
        add = findViewById(R.id.add);
        add.setOnClickListener(this);
        read = findViewById(R.id.read);
        read.setOnClickListener(this);
        remove = findViewById(R.id.remove);
        remove.setOnClickListener(this);
        name = findViewById(R.id.name);
        name.setOnClickListener(this);
        email = findViewById(R.id.email);
        email.setOnClickListener(this);
        text = findViewById(R.id.text);
        showPeoples = findViewById(R.id.showPeoples);
        showPeoples.setOnClickListener(this);
        allDelete = findViewById(R.id.all_delete);
        allDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String textName = String.valueOf(this.name.getText());
        String textEmail = String.valueOf(this.email.getText());
        switch (v.getId()) {
            case R.id.add:
                presenter.addPeople(textName, textEmail);
                break;
            case R.id.read:
                presenter.getPeople(textName);
                break;
            case R.id.remove:
                presenter.removePeople(textName, textEmail);
                break;
            case R.id.showPeoples:
                presenter.getPeooples();
                break;
            case R.id.all_delete:
                presenter.allDelete();
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
        text.setText("Список из БД: ");
        for (int i = 0; i < peoples.size(); i++) {
            text.append(i + ") " + "peopel name " + peoples.get(i).name + " email: " + peoples.get(i).email + "       ");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                System.getProperty("line.separator");
            }
            //TODO add in recyclerView + adapter and delete logic...
        }
    }
}