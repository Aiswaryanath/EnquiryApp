package com.student.admin.enquiryapp1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Button b,b1;
    String p1,p2,p3,p4,p5,p6,getemailid,getmobileno,getplace,getmessage,getpurpose;
    Enquiryhelper enquiryhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.emailid);
        ed3 = (EditText) findViewById(R.id.mobileno);
        ed4 = (EditText) findViewById(R.id.place);
        ed5 = (EditText) findViewById(R.id.message);
        ed6 = (EditText) findViewById(R.id.purpose);
        enquiryhelper=new Enquiryhelper(this);
        enquiryhelper.getWritableDatabase();
        b = (Button) findViewById(R.id.search);
        b1 = (Button) findViewById(R.id.update);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1=ed1.getText().toString();
                p2=ed2.getText().toString();
                p3=ed3.getText().toString();
                p4=ed4.getText().toString();
                p5=ed5.getText().toString();
                p6=ed6.getText().toString();
                Log.d("name",p1);
                Cursor cursor=enquiryhelper.SearchData(p1);
                if (cursor.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"no name found",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while (cursor.moveToNext())
                    {
                        p2=cursor.getString(2);
                        p3=cursor.getString(3);
                        p4=cursor.getString(4);
                        p5=cursor.getString(5);
                        p6=cursor.getString(6);
                        Toast.makeText(getApplicationContext(),p2,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),p3,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),p4,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),p5,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),p6,Toast.LENGTH_LONG).show();
                        ed2.setText(p2);
                        ed3.setText(p3);
                        ed4.setText(p4);
                        ed5.setText(p5);
                        ed6.setText(p6);
                        Toast.makeText(getApplicationContext(),p1,Toast.LENGTH_LONG).show();

                    }
                }

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
