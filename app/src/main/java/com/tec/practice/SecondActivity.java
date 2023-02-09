package com.tec.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
//    public class SecondActivity extends AppCompatActivity {

    Intent intent;
    RadioGroup rbGroup;

    String send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnSecondToMain = findViewById(R.id.btnSecondToMain);
        TextView txtFromMain = findViewById(R.id.txtFromMain);
        rbGroup = findViewById(R.id.rbGroup);
        rbGroup.setOnCheckedChangeListener(this);

//        EditText txtSecondToMain = findViewById(R.id.txtSecondToMain);

        intent = getIntent();
        String text = intent.getStringExtra("txtMainToSecond");
        txtFromMain.setText(text);

        btnSecondToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("textFromSecond", send);
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });

//        btnSecondToMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent.putExtra("textFromSecond", txtSecondToMain.getText().toString());
//                setResult(Activity.RESULT_OK, intent);
//
//                finish();
//            }
//        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        isChecked(checkedId);
    }

    private void isChecked(int checkedId) {
        switch (checkedId) {
            case R.id.rbModtaget:
                send = "Modtaget";
                break;
            case R.id.rbIkkeModtaget:
                send = "Ikke modtaget";
                break;
            case R.id.rbKomIgen:
                send = "Kom igen";
                break;
        }
    }
}