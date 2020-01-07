package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);

        findImages();
    }

    private void findImages(){
        findViewById(R.id.next).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        edNickname = findViewById(R.id.nickname);
        String dataNickname = edNickname.getText().toString();

        if (!TextUtils.isEmpty(edNickname.getText().toString())){
            Intent age = new Intent(this, AgeActivity.class);
            SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
            preferences.edit().putString("nickname", edNickname.getText().toString()).commit();
            startActivityForResult(age, 100);
            setResult(RESULT_OK, age);
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
