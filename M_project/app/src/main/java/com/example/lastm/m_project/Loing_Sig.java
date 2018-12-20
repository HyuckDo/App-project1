package com.example.lastm.m_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Loing_Sig extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loing__sig);
    }


    public void onclick(View v){

        switch (v.getId()){

            case R.id.login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.sigin:
                Intent intent2 = new Intent(this, Sinup.class);
                startActivity(intent2);
                break;
        }

    }
}
