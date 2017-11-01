package com.zaaviyah.zaaviyah_sqlit;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchData extends AppCompatActivity {


    EditText serachText ;
    Button btnSearch ;
    TextView  name , email;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        databaseHelper = new DatabaseHelper (this);

        serachText = (EditText) findViewById(R.id.editSearch);

        btnSearch = (Button) findViewById(R.id.btnSearch_data);

        name = (TextView) findViewById(R.id.tvName);
        email = (TextView) findViewById(R.id.tvEmail);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor = databaseHelper.getData(serachText.getText().toString());

                name.setText("   ");
                email.setText("  ");

                while (cursor.moveToNext())
                {
                    name.setText(cursor.getString(1));
                    email.setText(cursor.getString(3));
                }
            }
        });

    }
}
