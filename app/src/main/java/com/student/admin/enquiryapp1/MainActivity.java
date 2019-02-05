package com.student.admin.enquiryapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5;
    Button b,b1;
    Spinner s;
    String p1,p2,p3,p4,p5,p6;
    Enquiryhelper enquiryhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.emailid);
        ed3 = (EditText) findViewById(R.id.mobileno);
        ed4 = (EditText) findViewById(R.id.place);
        ed5 = (EditText) findViewById(R.id.message);
        s=(Spinner)findViewById(R.id.p);
        enquiryhelper=new Enquiryhelper(this);
        enquiryhelper.getWritableDatabase();
        b=(Button)findViewById(R.id.contactus);
        b=(Button)findViewById(R.id.search);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1 = ed1.getText().toString();
                p2 = ed2.getText().toString();
                p3 = ed3.getText().toString();
                p4 = ed4.getText().toString();
                p5 = ed5.getText().toString();
                p6=s.getSelectedItem().toString();
                Log.d("name", p1);
                Log.d("emailid", p2);
                Log.d("mobileno", p3);
                Log.d("place", p4);
                Log.d("message", p5);
                boolean status = enquiryhelper.insertData(p1, p2, p3, p4, p5);
                if (status == true) {
                    Toast.makeText(getApplicationContext(), "successfully inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(i);
            }
        });
    }}

