package com.example.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddNotes extends AppCompatActivity {
    EditText edTitle , edDesc;
    Button addBtn;

    NoteHelper noteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_notes);

        edTitle = findViewById(R.id.edTitle);
        edDesc = findViewById(R.id.edDesc);
        addBtn = findViewById(R.id.addBtn);
        noteHelper = new NoteHelper(AddNotes.this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(edTitle.length()>0 && edDesc.length()>0){

                    noteHelper.insertData(edTitle.getText().toString() , edDesc.getText().toString());
                    Toast.makeText(AddNotes.this , "The data added successfully" , Toast.LENGTH_SHORT).show();
                    edDesc.setText("");
                    edTitle.setText("");
                    startActivity(new Intent(getApplicationContext() , MainActivity.class));
                }else{
                    Toast.makeText(AddNotes.this , "Fill all fields" , Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}