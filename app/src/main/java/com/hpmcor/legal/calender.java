package com.hpmcor.legal;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.hpmcor.legal.R;

import java.util.ArrayList;

public class calender extends AppCompatActivity {

    ListView list;


    Database db;

    Word word;

    ArrayList<Word> listitem;
    AdayaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        // cv=(CalendarView) findViewById(R.id.calender) ;

        adapter=new AdayaAdapter(this,listitem);
        db = new Database(this);



        listitem = new ArrayList<Word>();

        list = (ListView) findViewById(R.id.list);
        showdata();

////////////////////////////////////////////////



                list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {

                android.content.Intent intent=new android.content.Intent(calender.this,view2.class);
                String nam1 = listitem.get(position).getAname1();
                String nam2 = listitem.get(position).getAname2();
                String num = listitem.get(position).getAnumber();
                String typ = listitem.get(position).getAtype();
                String place = listitem.get(position).getAplace();
                String advoceNum = listitem.get(position).getAjudgenum();
                String date = listitem.get(position).getAdate();
                String time = listitem.get(position).getAtime();
                int img  = listitem.get(position).getAresourc();


                intent.putExtra("id1",nam1);
                intent.putExtra("id2",nam2);
                intent.putExtra("id3",num);
                intent.putExtra("id4",typ);
                intent.putExtra("id5",place);
                intent.putExtra("id6",advoceNum);
                intent.putExtra("id7",date);
                intent.putExtra("id8",time);
                intent.putExtra("id9",img);

                startActivity(intent);
            }
        });








    }


    public void showdata() {
        Cursor res2 = db.getDate();


        // get array of hilighted dates...
        ArrayList<String> arraylist = new ArrayList<String>();


        if (res2.getCount() == 0) {
            Toast.makeText(calender.this, "لا توجد بيانات " , Toast.LENGTH_LONG).show();

        } else {
            while (res2.moveToNext()) {
                String t1 = res2.getString(1);
                String t2 = res2.getString(2);
                String t3 = res2.getString(3);
                String t4 = res2.getString(4);
                String t5 = res2.getString(5);
                String t6 = res2.getString(6);
                String t7 = res2.getString(7);
                String t8 = res2.getString(8);

              //  Toast.makeText(calender.this, "" + t1, Toast.LENGTH_LONG).show();

                Word word=new Word(t1,t2,t3,t4,t5,t6,t7,t8,R.drawable.circularclock);
                listitem.add(word);

            }
            list = (ListView) findViewById(R.id.list);

            worksAdapter adapter=new worksAdapter(this,listitem);
            list.setAdapter(adapter);


        }

    }
}


