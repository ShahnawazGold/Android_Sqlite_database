package com.zaaviyah.zaaviyah_sqlit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Updatedata extends AppCompatActivity {

    Button btUpadted ;
    EditText name, number, email;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);

        databaseHelper = new DatabaseHelper (this);
        
        btUpadted = (Button) findViewById(R.id.btupdate_data);
        name = (EditText) findViewById(R.id.updateName);
        number = (EditText) findViewById(R.id.updateNumber);
        email = (EditText) findViewById(R.id.updateEmail);

        btUpadted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseHelper.updateData(number.getText().toString(),name.getText().toString(),email.getText().toString());
                
            }
        });

    }
}
