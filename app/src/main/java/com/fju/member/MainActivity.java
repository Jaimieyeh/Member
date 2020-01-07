package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_MEMBER = 100;
    private EditText nickname;
    private EditText age;
    private EditText gender;
    private String finalNickname;
    private String finalAge;
    private String finalGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nickname = findViewById(R.id.nick);
        age = findViewById(R.id.ag);
        gender = findViewById(R.id.gen);
    }

    public void login (View view){
        Intent nickname = new Intent(this, NicknameActivity.class);
        startActivityForResult(nickname, REQUEST_CODE_MEMBER);
    }

    @Override
    protected void onStart() {
        super.onStart();
        finalNickname = nickname.getText().toString();
        finalAge = age.getText().toString();
        finalGender = gender.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_MEMBER){
            if (resultCode != RESULT_OK){
                finish();
            } else {
                nickname.setText(getSharedPreferences("data", MODE_PRIVATE).getString("nickname", ""));
                age.setText(getSharedPreferences("data", MODE_PRIVATE).getString("age", ""));
                gender.setText(getSharedPreferences("data", MODE_PRIVATE).getString("gender", ""));
            }
        }
    }
}
