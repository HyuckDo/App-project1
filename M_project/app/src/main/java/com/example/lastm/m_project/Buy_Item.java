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

public class Buy_Item extends AppCompatActivity {

    GridView gridView;
    String[] list_des={"하나","둘","셋"};
    String[] list_price={"1","2","3"};
    int[] list_image={R.drawable.background,R.drawable.book,R.drawable.item};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy__item);

        gridView=findViewById(R.id.grid_view);

        CustomAdapter customAdpter=new CustomAdapter();
        gridView.setAdapter(customAdpter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Buy_Item.this,ListScreen.class);

                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list_image.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view1=getLayoutInflater().inflate(R.layout.row_data,null);

            TextView price=view1.findViewById(R.id.text_price);
            TextView des=view1.findViewById(R.id.text_des);
            ImageView image=view1.findViewById(R.id.imageView);

            price.setText(list_price[position]);
            des.setText(list_des[position]);
            image.setImageResource(list_image[position]);
            return view1;
        }
    }
}
