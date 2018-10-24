package com.hpmcor.legal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.hpmcor.legal.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

public class three extends AppCompatActivity {

    Database db;


    newm n=new newm();

    Button bt1,bt2,bt3,bt4;
    EditText e1,e2,e3,e4,e5,e6;
    ListView list;
    ArrayList<String> listitem;
    ArrayAdapter adapter;

 MaterialBetterSpinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        db=new Database(this);



        sp=(MaterialBetterSpinner) findViewById(R.id.type);

        String [] spinlist={"قضايا" ,"توكيل عام","توكيل رسمي خاص","اعمال الادارة"};

        ArrayAdapter<String> spinadapter=new ArrayAdapter<String>(three.this,android.R.layout.simple_dropdown_item_1line,spinlist);

        sp.setAdapter(spinadapter);

        bt1 = (Button) findViewById(R.id.enter);

        bt3 = (Button) findViewById(R.id.search);


        e1 = (EditText) findViewById(R.id.number);
        e2 = (EditText) findViewById(R.id.name);
        e3 = (EditText) findViewById(R.id.adress);
       // e4 = (EditText) findViewById(R.id.type);
        e5 = (EditText) findViewById(R.id.from);
        e6 = (EditText) findViewById(R.id.id);



        listitem=new ArrayList<String>();


        list=(ListView) findViewById(R.id.list);
      // showdata();
        //deleteData();




        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              int i=list.getSelectedItemPosition();
              String idd =String.valueOf(listitem.get(i));
             // int id=listitem.get(i);

                Intent intent=new Intent(three.this,search1.class);
                intent.putExtra("id",idd);
                startActivity(intent);

                Toast.makeText(three.this, "",Toast.LENGTH_LONG).show();
            }
        });






          bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String Number=e1.getText().toString();
                String Name=e2.getText().toString();
                String Adress=e3.getText().toString();
                String Type=String.valueOf(sp.getText());
                String From=e5.getText().toString();

                if(! Number.equals("") && !Name.equals("")){

                    boolean result= db.insertData(Number,Name,Adress,Type,From);


                    Toast.makeText(three.this,"تم تسجيل البيانات بنجاح",Toast.LENGTH_LONG).show();
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e5.setText("");
                    listitem.clear();
                     showdata();

                    // n.showdata();


                }
                else {
                    Toast.makeText(three.this,"من فضلك ادخل البيانات",Toast.LENGTH_LONG).show();

                }

            }
        });


    }


    public void showdata(){
        Cursor res=db.getAllrecord();
        if(res.getCount()==0){
            Toast.makeText(three.this,"no data",Toast.LENGTH_LONG).show();

        }
        else{

            while (res.moveToNext()) {

                ArrayList<String> listitem= new ArrayList<String>();
                String t1 = res.getString(0);
                String t2 = res.getString(1);
                String t3 = res.getString(2);
                String t4 = res.getString(3);
                String t5 = res.getString(4);
                String t6 = res.getString(5);

                listitem.add( t1 +" : الاسم : "+t3+"   ||   رقم التوكيل : " +t2+"               ");

             //   Log.v("t1       ,", t1);
            }
                adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listitem);

                list.setAdapter(adapter);


        }






    }


  /*  public void deleteData() {
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String ID=e6.getText().toString();
             Integer result = db.delete(ID);

                if(result>0){
                    Toast.makeText(three.this, "okay"+ID, Toast.LENGTH_LONG).show();
                    e6.setText(" ");

                    showdata();

                } else {
                    Toast.makeText(three.this, "noooooo", Toast.LENGTH_LONG).show();
                }
            }
        });


    } */


    @Override
    protected void onResume() {
        super.onResume();
        //newm n=new newm();
        showdata();
    }
}
