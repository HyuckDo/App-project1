package com.example.lastm.m_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sinup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinup);
    }

    public void onClickButton(View v){
        EditText txt = null;
        txt = (EditText)findViewById(R.id.etUserid);
        String ins_stno = txt.getText().toString();
        txt = (EditText)findViewById(R.id.etPassword);
        String ins_passwd = txt.getText().toString();
        txt = (EditText)findViewById(R.id.etNickname);
        String ins_ncname= txt.getText().toString();

        SQLiteDatabase db = openOrCreateDatabase(
                "test.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user"
                + "(_usrid INTEGER PRIMARY KEY AUTOINCREMENT, stno TEXT, passwd TEXT, ncname TEXT);");

        Cursor c =db.rawQuery("SELECT * FROM user WHERE stno = '"+ins_stno+"';", null);
        startManagingCursor(c);
        if(c.getCount() == 0){
            c = db.rawQuery("SELECT * FROM user WHERE ncname = '"+ins_ncname+"';", null);
            if(c.getCount() == 0){
                String sql = " INSERT INTO user (stno, passwd, ncname) VALUES(" +
                        "'" + ins_stno + "','"+ins_passwd+"','"+ins_ncname+"');";
                db.execSQL(sql);
                Toast msg = Toast.makeText(this, "정상적으로 가입되셨습니다",Toast.LENGTH_SHORT);
                msg.show();

                Intent intent_signcomplete = new Intent(this,LoginActivity.class);
                startActivity(intent_signcomplete);
            }
            else{
                Toast msg = Toast.makeText(this, "중복되는 닉네임입니다.",Toast.LENGTH_SHORT);
                msg.show();
            }

        }
        else{
            Toast msg = Toast.makeText(this, "중복되는 학번입니다",Toast.LENGTH_SHORT);
            msg.show();
        }


    }


}
