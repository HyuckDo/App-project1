package com.example.lastm.m_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class List2 extends AppCompatActivity {

    Adapter adapter1;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen2);

        viewPager = (ViewPager) findViewById(R.id.list_pagerView);
        adapter1 = new Adapter(this);
        viewPager.setAdapter(adapter1);

        //String[] values = {"테스트1", "테스트2", "테스트3", "테스트4"};

       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, values);*/
        // setListAdapter(adapter);

    }

        public void onListItemClick (View v){
            //super.onListItemClick(l, v, position, id);

        }


}

