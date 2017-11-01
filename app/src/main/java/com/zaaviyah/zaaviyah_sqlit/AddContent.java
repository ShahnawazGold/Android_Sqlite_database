package com.zaaviyah.zaaviyah_sqlit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddContent extends AppCompatActivity {

    DatabaseHelper databaseHelper ;
    EditText name, phone , email;
     Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);

        databaseHelper = new DatabaseHelper (this);

        name = (EditText) findViewById(R.id.editName);
        phone = (EditText) findViewById(R.id.editPhone);
        email = (EditText) findViewById(R.id.editEmail);

        save = (Button) findViewById(R.id.btSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean result = databaseHelper.insertContact (name.getText().toString(),Integer.parseInt(phone.getText().toString()) ,email.getText().toString());
              if (result)
              {
                  Toast.makeText(AddContent.this, "data inserted", Toast.LENGTH_SHORT).show();
              }else{
                  Toast.makeText(AddContent.this, "data not inserted ", Toast.LENGTH_SHORT).show();

              }
            }
        });

    }
}
