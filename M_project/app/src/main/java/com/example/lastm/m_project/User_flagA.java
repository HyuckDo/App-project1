package com.example.lastm.m_project;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.CursorLoader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class User_flagA extends Fragment {
    private String key = null;

    private EditText txt = null;
    private TextView stntxt = null;

    private SQLiteDatabase db =  null;


    public User_flagA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user_flag,container,false);

        File file = new File("data/data/com.example.lastm.m_project/filesuser.txt");
        FileReader fr = null;
        try{
            fr = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(fr);
            key = bufReader.readLine();
            bufReader.close();
        }catch(Exception e){
            e.printStackTrace();
        }


        db = getContext().openOrCreateDatabase("test.db",Context.MODE_PRIVATE,null);
        Cursor c = db.rawQuery("SELECT * FROM user WHERE stno='"+key+"';", null);
        c.moveToFirst();
        String studnumber = c.getString(c.getColumnIndex("stno"));
        String nickname = c.getString(c.getColumnIndex("ncname"));

        stntxt = (TextView)v.findViewById(R.id.name);
        stntxt.setText("학번   : "+studnumber);
        stntxt = (TextView)v.findViewById(R.id.ni);
        stntxt.setText("닉네임   : "+nickname);

        Button updateAccountButton = (Button)v.findViewById(R.id.updateAccountButton);
        Button deleteAccountButton = (Button)v.findViewById(R.id.deleteAccountButton);

        updateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ins_ncname = txt.getText().toString();

                db = getContext().openOrCreateDatabase("test.db",Context.MODE_PRIVATE,null);
                Cursor c = db.rawQuery("SELECT * FROM user WHERE ncname = '"+ins_ncname+"';", null);
                c.moveToFirst();
                if(c.getCount() == 0){
                    String sql = "UPDATE user SET ncname = '"+ins_ncname+"' WHERE stno = '"+key+"';";
                    db.execSQL(sql);
                    Toast msg = Toast.makeText(getContext(), "닉네임이 수정되었습니다.",Toast.LENGTH_SHORT);
                    msg.show();


                    c = db.rawQuery("SELECT * FROM user WHERE stno ='"+key+"';", null);
                    c.moveToFirst();
                    stntxt.setText("닉네임   : "+c.getString(c.getColumnIndex("ncname")));
                }
                else{
                    Toast msg = Toast.makeText(getContext(), "중복되는 닉네임입니다.",Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });

        deleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = getContext().openOrCreateDatabase("test.db",Context.MODE_PRIVATE,null);
                String sql = "DELETE FROM user WHERE stno= '"+key+"';";
                db.execSQL(sql);
                Toast msg = Toast.makeText(getContext(), "탈퇴되었습니다.",Toast.LENGTH_SHORT);
                msg.show();

                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });

        return v;
    }

}

