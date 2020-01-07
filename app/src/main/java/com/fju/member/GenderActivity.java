package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        findImages();
    }

    private void findImages(){
        findViewById(R.id.done).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        edGender = findViewById(R.id.gender);
        String dataGender = edGender.getText().toString();

        if (!TextUtils.isEmpty(edGender.getText().toString())){
            Intent result = new Intent(this, MainActivity.class);
            SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
            preferences.edit().putString("gender", edGender.getText().toString()).commit();
            //startActivityForResult(result, 100);
            setResult(RESULT_OK, result);
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
