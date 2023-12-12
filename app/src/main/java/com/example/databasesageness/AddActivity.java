package com.example.databasesageness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                String inputValue_title = editText_title.getText().toString();
                String inputValue_author = editText_title.getText().toString();
                String inputValue_pages = editText_title.getText().toString();
                if(inputValue_title.trim().isEmpty() || inputValue_author.trim().isEmpty() ||
                    inputValue_pages.trim().isEmpty()){
                    Toast.makeText(AddActivity.this, "No data", Toast.LENGTH_SHORT).show();
                }else {
                    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(AddActivity.this);
                    myDatabaseHelper.dbaddBook(editText_title.getText().toString().trim(),
                            editText_author.getText().toString().trim(),
                            Integer.valueOf(editText_pages.getText().toString().trim()));
                    finish();
                }
            }
        });
    }
}