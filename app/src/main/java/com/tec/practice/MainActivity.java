package com.tec.practice;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> secondActivityLauncher;
    ActivityResultLauncher<Intent> thirdActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnToSecond = findViewById(R.id.btnToSecond);
        Button btnToThird = findViewById(R.id.btnToThird);
        TextView txtFromSecond = findViewById(R.id.txtFromSecond);
        TextView txtFromThird = findViewById(R.id.txtFromThird);
        EditText txtSendToSecond = findViewById(R.id.txtSendToSecond);
        EditText txtSendToThird = findViewById(R.id.txtSendToThird);

        btnToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String textSecond = txtSendToSecond.getText().toString();
                intent.putExtra("txtMainToSecond", textSecond);
                secondActivityLauncher.launch(intent);
            }
        });

        btnToThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                String textThird = txtSendToThird.getText().toString();
                intent.putExtra("txtMainToThird", textThird);
                thirdActivityLauncher.launch(intent);
            }
        });

        secondActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        String text = intent.getStringExtra("textFromSecond");
                        txtFromSecond.setText(text);
                    }
                }
        );

        thirdActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        String text = intent.getStringExtra("textFromThird");
                        txtFromThird.setText(text);
                    }
                }
        );
    }
}