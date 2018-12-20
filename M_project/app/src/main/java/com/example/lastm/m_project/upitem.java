package com.example.lastm.m_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class upitem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upitem);
    }


    public void onclickup(View v){

        switch (v.getId()){
            case R.id.button2:
                Intent i = new Intent(upitem.this, MainActivity.class);
                startActivity(i);
                break;
        }

    }
}
