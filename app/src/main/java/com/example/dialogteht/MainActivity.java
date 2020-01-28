package com.example.dialogteht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.app.DialogFragment;
import android.view.View;
import android.content.Context;
import android.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private Button addtime;

    ListView listView;
    ArrayList<String> lista;
    ArrayAdapter<String> stringArrayAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView testi = (ListView) findViewById(R.id.listaViewi);

        lista = new ArrayList<>();

        stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);


        listView = findViewById(R.id.listaViewi);

        listView.setAdapter(stringArrayAdapter);




        this.addtime = findViewById(R.id.addtime);

        this.addtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(MainActivity.this)

                        .setMessage("Add current time?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                String date = new SimpleDateFormat("dd-MM-YYYY / HH:mm", Locale.getDefault()).format(new Date());
                                stringArrayAdapter.add(date);

                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .show();

            }
        });

    }





}
