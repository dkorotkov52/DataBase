package com.example.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.read)
    Button read;
    @BindView(R.id.remove)
    Button remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.add, R.id.read, R.id.remove})
    public void onClick(View view) {
        String name = this.name.getText().toString();
        String email = this.email.getText().toString();

        switch (view.getId()) {
            case R.id.add:
                //TODO
                break;
            case R.id.read:
                //TODO
                break;
            case R.id.remove:
                //TODO
                break;
        }
    }
}