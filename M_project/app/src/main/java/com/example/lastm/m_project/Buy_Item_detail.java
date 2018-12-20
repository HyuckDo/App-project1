package com.example.lastm.m_project;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Buy_Item_detail extends AppCompatActivity {

    TextView price;
    TextView des;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy__item_detail);
        price = findViewById(R.id.textView);
        des = findViewById(R.id.textView2);
        image = findViewById(R.id.imageView2);

        Intent intent = getIntent();
        price.setText(intent.getStringExtra("price"));
        des.setText(intent.getStringExtra("des"));
        image.setImageResource(intent.getIntExtra("image", 0));

    }
}
