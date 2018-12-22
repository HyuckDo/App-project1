package com.example.lastm.m_project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class User_flagB extends Fragment {
    String[] menu={"1","2","3","2","3","2","3","2"};
    int[] IMAGES={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,};
    String[] DES={"C book"};
    public User_flagB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_user_flag_b, container, false);
        // Inflate the layout for this fragment
        CustomAdapter customAdapter=new CustomAdapter();
        ListView listView=(ListView) view.findViewById(R.id.listView);
        ArrayAdapter<String> ListViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menu
        );
        listView.setAdapter(customAdapter);
        return view;
    }

    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return DES.length;
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
        public View getView(int position, View view, ViewGroup parent) {
            view=getLayoutInflater().inflate(R.layout.costom,null);
            //  ImageView imageView=(ImageView) view.findViewById(R.id.imageView);
            // TextView textView_name=(TextView)view.findViewById(R.id.textView_name);
            TextView textView_des=(TextView)view.findViewById(R.id.textView_des);

            // imageView.setImageResource(IMAGES[position]);
            //    textView_name.setText(menu[position]);
            textView_des.setText(DES[position]);
            return view;
        }

    }

}
