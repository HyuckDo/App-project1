package com.example.lastm.m_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onclickNext(View v){

        switch (v.getId()){
            case R.id.buy_book :
                Intent i = new Intent(MainActivity.this, Buy_Item.class);
                startActivity(i);
                break;
            case R.id.buy_item :
                Intent i2 = new Intent(MainActivity.this, Buy_Item.class);
                startActivity(i2);
                break;
            case R.id.sell_LL :
                Intent i3 = new Intent(MainActivity.this, Loing_Sig.class);
                startActivity(i3);
                break;
        }
    }



}
