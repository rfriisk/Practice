package com.tec.practice;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtThirdToMain;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button btnThirdToMain = findViewById(R.id.btnThirdToMain);
        TextView txtFromMain = findViewById(R.id.txtFromMain);
        txtThirdToMain = findViewById(R.id.txtThirdToMain);

        intent = getIntent();
        String text = intent.getStringExtra("txtMainToThird");

        txtFromMain.setText(text);

        btnThirdToMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        intent.putExtra("textFromThird", txtThirdToMain.getText().toString());
        setResult(Activity.RESULT_OK, intent);

        finish();
    }
}