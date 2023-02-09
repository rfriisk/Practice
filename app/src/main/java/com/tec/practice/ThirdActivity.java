package com.tec.practice;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    //EditText txtThirdToMain;
    Intent intent;
    Spinner spnRespons;
    String txtThirdToMain;

    String[] answers = {"Livet er et eventyr", "Glæde er smittende", "Smil ændrer alt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button btnThirdToMain = findViewById(R.id.btnThirdToMain);
        TextView txtFromMain = findViewById(R.id.txtFromMain);
        spnRespons = findViewById(R.id.spnRespons);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, answers);
        spnRespons.setAdapter(adapter);

        spnRespons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                txtThirdToMain = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // txtThirdToMain = findViewById(R.id.txtThirdToMain);

        intent = getIntent();
        String text = intent.getStringExtra("txtMainToThird");

        txtFromMain.setText(text);

        btnThirdToMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        intent.putExtra("textFromThird", txtThirdToMain);
        setResult(Activity.RESULT_OK, intent);

        finish();
    }

//    @Override
//    public void onClick(View view) {
//        intent.putExtra("textFromThird", txtThirdToMain.getText().toString());
//        setResult(Activity.RESULT_OK, intent);
//
//        finish();
//    }
}