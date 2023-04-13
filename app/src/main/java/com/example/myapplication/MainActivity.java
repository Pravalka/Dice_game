package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button btnOne,btnTwo,aler;
    int randomValue1;
    int randomValue2;
    String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editTextNumber);
        e2 = findViewById(R.id.editTextNumber2);

        btnOne = findViewById(R.id.button);
        btnTwo = findViewById(R.id.button2);
        aler = findViewById(R.id.button3);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minimum = 1;
                int maximum = 6;
                randomValue1 = minimum + (int)(Math.random() * maximum);
                e1.setText(String.valueOf(randomValue1));
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minimum = 1;
                int maximum = 6;
                randomValue2 = minimum + (int)(Math.random() * maximum);
                e2.setText(String.valueOf(randomValue2));
            }
        });

        aler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int val1 = Integer.parseInt(e1.getText().toString());
                int val2 = Integer.parseInt(e2.getText().toString());
                if(val1>val2)
                {
                    result = "User1";
                }
                else if(val1==val2)
                {
                    result = "No one";
                }
                else
                {
                    result = "User2";
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_stat_name);
                builder.setTitle("Dice Game");
                builder.setMessage(""+result+" is winner");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Hurry!!Play the game again!", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.setCancelable(true);
                    }
                });
                builder.create();
                builder.show();
            }
        });


    }
}