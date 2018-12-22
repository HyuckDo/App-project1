package com.example.lastm.m_project;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class upitem extends AppCompatActivity {

    private static final int PICK_FROM_CAMERA = 0;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_IMAGE = 2;
    private Uri mlmageCaptureUri;
    private String absoultePath;

    EditText name = null; // 제목
    RadioGroup group; // 책, 생필품 그룹
    RadioButton item; // 선택
    ImageView image; // 상품 이미지
    EditText price= null; // 가격
    EditText explain= null; // 상세 설명
    String s_name;
    String s_choice;
    Integer s_price;
    String s_explain;
    ImageView image2;
    byte[] ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upitem);

        name = (EditText)findViewById(R.id.text_name); // 제목
        group = (RadioGroup)findViewById(R.id.check_group); // 책, 생필품 선택
        image = (ImageView) findViewById(R.id.item_image); // 상품 이미지
        price = (EditText) findViewById(R.id.price); // 가격
        explain = (EditText)findViewById(R.id.item_explain); // 상세 설명
        //int a = group.getCheckedRadioButtonId();



    }

    //이미지 등록하기
    public  void onImageClick(View v){

        switch(v.getId()){
            case R.id.image:{

                DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doTakePhotoAction();
                    }
                };
                DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doTakeAlbumAction();
                    }
                };
                DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                };

                new AlertDialog.Builder(this)
                        .setTitle("업로드할 이미지 선택")
                        .setPositiveButton("사진촬영", cameraListener)
                        .setNeutralButton("앨범선택", albumListener)
                        .setNegativeButton("취소", cancelListener)
                        .show();

            }

        }

    }
    //상품 등록하기
    @SuppressLint("WrongConstant")
    public void onClickUp(View v){
        switch (v.getId()) {
            case R.id.upload: {


                item = (RadioButton) findViewById(group.getCheckedRadioButtonId()); // 생필품 선택
                s_name = name.getText().toString();
                s_choice = item.getText().toString();
                s_price  = Integer.parseInt(price.getText().toString());
                s_explain = explain.getText().toString();


                try {

                    //String sql = "INSERT INTO people (name, age) VALUES ('" + ins_stno + "'," +age+");";
                    //  String sql = "INSERT INTO people (name, age) VALUES ('jeongkook', 22);";
                    /*
                    EditText txt = null;
                    txt = (EditText)findViewById(R.id.text_name);
                    String cname  = txt.getText().toString();
                    txt = (EditText)findViewById(R.id.price);
                    Integer age  = Integer.parseInt(txt.getText().toString());
                    txt = (EditText)findViewById(R.id.item_explain);
                    String name = txt.getText().toString();

                    SQLiteDatabase db = openOrCreateDatabase(
                            "item1.db",
                            SQLiteDatabase.CREATE_IF_NECESSARY,
                            null);
                    db.execSQL("CREATE TABLE IF NOT EXISTS item"
                            + "(code INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,  price INTEGER, explaini TEXT);");

                    Cursor c =db.rawQuery("SELECT * FROM item WHERE name = '"+cname+"';", null);
                    startManagingCursor(c);
                    if(c.getCount() == 0) {
                        c = db.rawQuery("SELECT * FROM item WHERE name = '"+cname+"';", null);
                        if (c.getCount() == 0) {
                            String sql = "INSERT INTO item (name, price, explaini) VALUES('" + cname+"','"+ age+ "','" + name +"');";
                            db.execSQL(sql);

                        }
                    }

                    */
                    Intent intent = new Intent(upitem.this, User_main.class);
                    startActivity(intent);
                    finish();

                } catch (SQLiteException se) {
                    Toast.makeText(getApplicationContext(),  se.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("", se.getMessage());


                }





                /*
                Intent i = new Intent(upitem.this, MainActivity.class);
                startActivity(i);
                break;
                */
            }
        }

    }

    //카메라에서 사진 촬영
    public void doTakePhotoAction(){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        String url = "tep_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        mlmageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));

        intent.putExtra(MediaStore.EXTRA_OUTPUT, mlmageCaptureUri);
        startActivityForResult(intent, PICK_FROM_CAMERA);

    }

    //앨범에서 이미지 가져오기
    public void doTakeAlbumAction(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != RESULT_OK) return;

        switch(requestCode){

            case PICK_FROM_ALBUM:{
                mlmageCaptureUri = data.getData();
            }

            case PICK_FROM_CAMERA:{
                // 이미지 크기 리사이즈
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mlmageCaptureUri, "image/*");

                intent.putExtra("outputX", 300);
                intent.putExtra("outputY", 300);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, CROP_FROM_IMAGE);
                break;
            }

            case CROP_FROM_IMAGE:{
                //크롭 된 이후 이미지 넘겨 받음

                if(resultCode != RESULT_OK) return;

                final Bundle extras = data.getExtras();

                //크롭된 이미지를 저장하기 위한 파일 경로
                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+
                        "/SmartWheel/" + System.currentTimeMillis()+".jpg";

                if(extras != null){
                    Bitmap photo = extras.getParcelable("data");
                    image.setImageBitmap(photo); // 이미지 칸에 이미지 보여줌
                    ch = getByteArrayFromDrawable(image.getDrawable());





                    storeCropImage(photo, filePath); // 크롭된 이미지를 외부저장소, 앨범에 저장
                    absoultePath = filePath;
                    break;
                }

                File f = new File(mlmageCaptureUri.getPath());
                if(f.exists()) f.delete();

            }
        }

    }
    // bitmap 저장
    private void storeCropImage(Bitmap bitmap, String filePath){
        //SmartWheel 폴더를 생성하여 이미지를 저장
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() +
                "/SmartWheel";
        File directory_SmartWheel = new File(dirPath);
        //SmartWheel 폴더가 없으면
        if(!directory_SmartWheel.exists())
            directory_SmartWheel.mkdir();

        File copyFile = new File(filePath);
        BufferedOutputStream out = null;

        try {

            copyFile.createNewFile();
            out = new BufferedOutputStream(new FileOutputStream(copyFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

            //sendBroadcast를 통해 크롭된 사진을 앨범에 보이게 함
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(copyFile)));

            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public byte[] getByteArrayFromDrawable(Drawable d){

        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] data = stream.toByteArray();

        return data;
    }


}
