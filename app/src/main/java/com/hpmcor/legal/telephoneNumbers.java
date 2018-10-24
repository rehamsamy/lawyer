package com.hpmcor.legal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.hpmcor.legal.R;

public class telephoneNumbers extends AppCompatActivity {


    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7;
    ListView listt;

    RelativeLayout ln;
    telphonecontent cnt = new telphonecontent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone_numbers);

        ln = (RelativeLayout) findViewById(R.id.lin);
        listt = (ListView) findViewById(R.id.list);
        bt1 = (Button) findViewById(R.id.cairo);
        bt2 = (Button) findViewById(R.id.giza);
        bt3 = (Button) findViewById(R.id.fayoum);
        bt4 = (Button) findViewById(R.id.asout);
        bt5 = (Button) findViewById(R.id.ena);
        bt6 = (Button) findViewById(R.id.aswan);
        bt7 = (Button) findViewById(R.id.daha);
    }


    public void cairo(View view){
        Intent i=new Intent(telephoneNumbers.this,telphonecontent.class);
        i.putExtra("id",0);
        this.startActivity(i);
    }

    public void giza(View view){
        Intent i=new Intent(telephoneNumbers.this,telphonecontent.class);
        i.putExtra("id",1);
        this.startActivity(i);
    }


    public void fayoum(View view){
        Intent i=new Intent(telephoneNumbers.this,telphonecontent.class);
        i.putExtra("id",2);
        this.startActivity(i);
    }


    public void asout(View view){
        Intent i=new Intent(telephoneNumbers.this,telphonecontent.class);
        i.putExtra("id",3);
        this.startActivity(i);
    }

    public void ena(View view){
        Intent i=new Intent(telephoneNumbers.this,telphonecontent.class);
        i.putExtra("id",4);
        this.startActivity(i);
    }

    public void aswan(View view){
        Intent i=new Intent(telephoneNumbers.this,telphonecontent.class);
        i.putExtra("id",5);
        this.startActivity(i);
    }

    public void daha(View view){
        Intent i=new Intent(telephoneNumbers.this,telphonecontent.class);
        i.putExtra("id",6);
        this.startActivity(i);
    }






}



