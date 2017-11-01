package com.zaaviyah.zaaviyah_sqlit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper ;

    Button insert ,searchData ,btDelete,btUpdate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper (this);

        insert = (Button) findViewById(R.id.btAddCont) ;

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentAddContent = new Intent(MainActivity.this,AddContent.class ) ;
                startActivity(intentAddContent);
            }
        });


        searchData = (Button) findViewById(R.id.btnSearch_data);

        searchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentSearch = new Intent(MainActivity.this,SearchData.class);
                startActivity(intentSearch);
            }
        });

        btDelete = (Button) findViewById(R.id.btnDelete);

        btDelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intentDelete = new Intent(MainActivity.this,Deleted.class);
                startActivity(intentDelete);
            }
        });

        btUpdate= (Button) findViewById(R.id.btnUpdate);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentUpdate = new Intent(MainActivity.this,Updatedata.class);
                startActivity(intentUpdate);
            }
        });

    }
}
