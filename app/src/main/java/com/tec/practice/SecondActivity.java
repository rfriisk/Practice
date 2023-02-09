package com.tec.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnSecondToMain = findViewById(R.id.btnSecondToMain);
        TextView txtFromMain = findViewById(R.id.txtFromMain);
        EditText txtSecondToMain = findViewById(R.id.txtSecondToMain);

        intent = getIntent();
        String text = intent.getStringExtra("txtMainToSecond");
        txtFromMain.setText(text);

        btnSecondToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("textFromSecond", txtSecondToMain.getText().toString());
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }
}