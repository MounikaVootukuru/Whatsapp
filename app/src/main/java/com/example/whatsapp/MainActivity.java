package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 Uri Content_uri =Uri.parse("content://com.mounika.my.company.provider/emp");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLoading(View view) {
        Cursor cr=getContentResolver().query(Content_uri,null,null,null,"");
        StringBuilder st = new StringBuilder();

        while(cr.moveToNext())
        {
            int id=cr.getInt(0);
            String s1=cr.getString(1);
            String s2=cr.getString(2);
            st.append(id +"     "+s1+"   "+s2+"   \n ");
        }
        Toast.makeText(this,st.toString(),Toast.LENGTH_SHORT).show();
    }
}
