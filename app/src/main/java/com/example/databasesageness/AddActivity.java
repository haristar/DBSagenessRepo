package com.example.databasesageness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText editText_title, editText_author, editText_pages;
    Button button_dbadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editText_title = findViewById(R.id.title_input);
        editText_author = findViewById(R.id.author_input);
        editText_pages = findViewById(R.id.pages_input);
        button_dbadd = findViewById(R.id.dbadd_button);

        button_dbadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(AddActivity.this);
                myDatabaseHelper.dbaddBook(editText_title.getText().toString().trim(),
                                            editText_author.getText().toString().trim(),
                                            Integer.valueOf(editText_pages.getText().toString().trim()));
            }
        });
    }
}