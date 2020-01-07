package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edAge;

    //first time
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        findImages();
    }

    private void findImages(){
        findViewById(R.id.next2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        edAge = findViewById(R.id.age);
        String dataAge = edAge.getText().toString();

        if (!TextUtils.isEmpty(edAge.getText().toString())){
            Intent gender = new Intent(this, GenderActivity.class);
            SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
            preferences.edit().putString("age", edAge.getText().toString()).commit();
            startActivityForResult(gender, 100);
            setResult(RESULT_OK, gender);
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Wrong")
                    .setMessage("must type")
                    .setPositiveButton("OK", null)
                    .show();
        }

    }
}
