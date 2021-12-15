package com.example.androidtodo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidtodo.pojo.Todo;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity {
    private static final String KEY_TVTODO = "tvTodo";
    private static final String TAG = "Todo";
    String TvState = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called");
        if (savedInstanceState ==null){
            Toast.makeText(getApplicationContext(),
                    "Welcome !",
                    Toast.LENGTH_SHORT)
                    .show();
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "Welcome back !",
                    Toast.LENGTH_SHORT)
                    .show();
            TvState = savedInstanceState.getString(KEY_TVTODO);

        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "OnRestoreInstanceState() called");
        TextView tvTodo = (TextView) findViewById(R.id.TvTodos);
        tvTodo.setText(TvState);


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "OnSaveInstanceState() called");
        outState.putString(KEY_TVTODO, TvState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cheat:
                Intent intent = new Intent(getApplicationContext(), AddTodoActivity.class);
                startActivityForResult(intent,1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView tvTodo = (TextView) findViewById(R.id.TvTodos);
        if(requestCode == 1 && resultCode==RESULT_OK) {
            Todo newTodo = (Todo) data.getSerializableExtra("Todo");
            tvTodo.setText( tvTodo.getText().toString() + System.getProperty("line.separator") +newTodo.getId() + ".  " + newTodo.getName() + "//" + newTodo.getUrgency());
        }
        else if (resultCode == RESULT_CANCELED && requestCode ==1){
            Toast.makeText(getApplicationContext(),
                    "Canceled",
                    Toast.LENGTH_SHORT)
                    .show();
        }

    }
}