package com.example.lastm.m_project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class User_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);


        if(findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null){
                return;
            }

            User_flagA firstFragment = new User_flagA();
            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();

        }
    }

    public void selectFragment(View view) {
        Fragment fr = null;

        switch (view.getId()) {
            case R.id.button1 :
                fr = new User_flagA();
                break;
            case R.id.button2:
                fr = new User_flagB();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
