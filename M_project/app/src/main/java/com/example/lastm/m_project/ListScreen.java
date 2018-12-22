package com.example.lastm.m_project;

import android.app.ListActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListScreen extends AppCompatActivity {

    Adapter adapter1;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen);
        viewPager=(ViewPager)findViewById(R.id.list_pagerView);
        adapter1=new Adapter(this);
        viewPager.setAdapter(adapter1);
     //   String [] values = {"테스트1","테스트2","테스트3","테스트4"};

       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, values);
       // setListAdapter(adapter);*/
    }
/*
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item+"selected",Toast.LENGTH_SHORT).show();
    }
*/
}

