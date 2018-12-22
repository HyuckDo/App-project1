package com.example.lastm.m_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Adapter extends PagerAdapter {

    private int[] images={R.drawable.background,R.drawable.book,R.drawable.item};
    private LayoutInflater inflater;
    private Context context;

    public Adapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject( View view, Object o) {
        return view==((RelativeLayout)o);
    }


    @Override
    public Object instantiateItem( ViewGroup container, int position) {

        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v= inflater.inflate(R.layout.slider,container,false);
        ImageView imageView=(ImageView)v.findViewById(R.id.test_image);
        TextView textView=(TextView)v.findViewById(R.id.test_text);
        imageView.setImageResource(images[position]);
        textView.setText((position+1)+"/"+this.getCount());
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
       container.invalidate();
    }
}
