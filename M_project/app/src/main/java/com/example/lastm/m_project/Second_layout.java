package com.example.lastm.m_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 김민석 on 2018-12-06.
 */
public class Second_layout extends Fragment {
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_second_layout, container, false);
        return v;
    }
}