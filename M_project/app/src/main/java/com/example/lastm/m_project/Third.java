package com.example.lastm.m_project;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Created by 김민석 on 2018-12-22.
 */

public class Third extends Fragment {

    private GridView gv;
    /* private ArrayAdapter<String> adapter;*/

    /*private static String[] spacecrafts = {"Columbia", "Apollo 15", "Apollo 17", "Chandra"};*/
    private String[] list_des = {"하나", "둘", "셋"};
    private String[] list_price = {"1", "2", "3"};
    private int[] list_image = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

    public static Third newInstance() {
        Third third = new Third();

        return third;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {


        View rootView = inflater.inflate(R.layout.third, null);


        /*gv = (GridView) rootView.findViewById(R.id.first_layout_GV);*/

        gv = (GridView) rootView.findViewById(R.id.third_GV);

        CustomAdapter customAdpter = new CustomAdapter();
        gv.setAdapter(customAdpter);
        /* gv.setAdapter((new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list_price)));*/

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long I) {
                /* adapterView.getItemAtPosition(position);

                 */
                /*Toast.makeText(getActivity(), list_price[position], Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), list_des[position], Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), list_image[position], Toast.LENGTH_SHORT).show();*/
               /* Intent intent = new Intent(getActivity(),Detail.class);
                intent.putExtra("price",list_price[position]);
                intent.putExtra("des",list_des[position]);
                intent.putExtra("image",list_image[position]);
                startActivity(intent);*/
                /*Firstlayout.this.getFragmentManager().beginTransaction().replace(R.id.first_layout_GV, Detail.newInstance()).commit();*/

                Intent intent=new Intent(getActivity(), ListScreen2.class);
                intent.putExtra("price",list_price[position]);
                intent.putExtra("des",list_des[position]);
                intent.putExtra("image",list_image[position]);
                startActivity(intent);

            }

        });

            /*@Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Detail.class);
                *//*intent.putExtra("price",list_price[position]);
                intent.putExtra("des",list_des[position]);*//*
                intent.putExtra("image",list_image[position]);
                startActivity(intent);
            }*/
        return rootView;
    }

    private class CustomAdapter extends BaseAdapter {

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

            View view1 = getLayoutInflater().inflate(R.layout.sub, null);

            TextView price = view1.findViewById(R.id.text_price);
            TextView des = view1.findViewById(R.id.text_des);
            ImageView image = view1.findViewById(R.id.imageView);

            price.setText(list_price[position]);
            des.setText(list_des[position]);
            image.setImageResource(list_image[position]);
            return view1;
        }

        public String toString() {
            return "Third";
        }
    }


}