package com.zaaviyah.zaaviyah_sqlit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Deleted extends AppCompatActivity {


    Button btnsDelete;
    EditText etidNumber ;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleted);

        databaseHelper = new DatabaseHelper (this);

        btnsDelete = (Button) findViewById(R.id.btDelete);
        etidNumber = (EditText) findViewById(R.id.etNumber);

        btnsDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseHelper.deleteData(etidNumber.getText().toString());

            }
        });

    }
}
