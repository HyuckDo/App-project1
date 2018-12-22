package com.example.lastm.m_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    public void LogInOnClick(View v){

        switch(v.getId()){ // 로그인
            case R.id.button1 :{
                EditText txt = null;
                txt = (EditText)findViewById(R.id.login_etid);
                String ins_stno = txt.getText().toString();
                txt = (EditText)findViewById(R.id.login_etpasswd);
                String ins_passwd = txt.getText().toString();

                SQLiteDatabase db = openOrCreateDatabase(
                        "test.db",
                        SQLiteDatabase.CREATE_IF_NECESSARY,
                        null);
                db.execSQL("CREATE TABLE IF NOT EXISTS user"
                        + "(_usrid INTEGER PRIMARY KEY AUTOINCREMENT, stno TEXT, passwd TEXT, ncname TEXT);");

                Cursor c =db.rawQuery("SELECT * FROM user WHERE stno = '"+ins_stno+"' AND passwd = '"+ins_passwd+"';", null);
                c.moveToFirst();
                if(c.getCount() > 0)
                {
                    String key = ins_stno;
                    File file = new File(getFilesDir() + "user.txt");
                    try{
                        FileWriter fw  = new FileWriter(file);
                        fw.write(key);
                        fw.close();

                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(this, upitem.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast msg = Toast.makeText(this, "ID 혹은 비밀번호가 다릅니다.",Toast.LENGTH_SHORT);
                    msg.show();
                }
                break;
            }
            case R.id.makeid : { // 회원 가입


                Intent intent = new Intent(LoginActivity.this, Sinup.class);
                startActivity(intent);
                break;


            }



        }

    }




}
