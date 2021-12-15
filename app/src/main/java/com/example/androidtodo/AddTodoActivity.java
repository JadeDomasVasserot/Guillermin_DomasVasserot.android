package com.example.androidtodo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtodo.pojo.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTodoActivity extends AppCompatActivity {
    //KEYS
    public static final String KEY_TODOOBJECT = "todoObject" ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //FindViewById --> récupère les éléments XML
        Button TvBtnAdd = (Button) findViewById(R.id.BtnAdd);
        Button TvBtnCancel = (Button)findViewById(R.id.BtnCancel);
        EditText EditNameTodo = (EditText) findViewById(R.id.EditNameTodo);
        Spinner spinner = (Spinner) findViewById(R.id.SpinnerUrgency);
    // création d'un tableau de type string contennant les différents niveaux de priorité
        String[] Urgency = new String[]{
                "Low Urgency",
                "Medium Urgency",
                "High Urgency"
        };
        final List<String> UrgencyList = new ArrayList<>(Arrays.asList(Urgency));
        //On initialise notre array pour notre spinner
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item,UrgencyList);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);

        //Au click du btnCancel
        TvBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                setResult(RESULT_CANCELED, resultIntent);
                finish();
            }
        });
        // Au click du BtnAdd
        TvBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UrgencyLvl = spinner.getSelectedItem().toString();
                String todoContent = EditNameTodo.getText().toString();
                if (todoContent.length()<3) {
                    Toast.makeText(getApplicationContext(),
                            "Le mot que vous avez saisie est inférieur à 3 caractères",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    Todo todoObject = new Todo(todoContent, UrgencyLvl);
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("Todo", todoObject);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
