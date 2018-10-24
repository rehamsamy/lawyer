package com.hpmcor.legal;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.hpmcor.legal.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class two extends AppCompatActivity {

    Button bt1, bt2, bt4;

    EditText e1, e2, e3, e4, e5, e6;
    int x44;
    int x77;
    int x88;
    TextView e7,e8;

    ListView list2;
    Database db;
    ArrayList<String> listitem;
    ArrayAdapter adapter;
    // adaya ad=new adaya();

   // Spinner sp;
    MaterialBetterSpinner sp;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        sp=(MaterialBetterSpinner) findViewById(R.id.type);

        String [] spinlist={"القضايا المالية","القضايا العقارية","القضايا الجنائية","القضايا الإنهائية","قضايا الأحوال الشخصية"};

        ArrayAdapter<String> spinadapter=new ArrayAdapter<String>(two.this,android.R.layout.simple_dropdown_item_1line,spinlist);

        sp.setAdapter(spinadapter);



        final Calendar c=Calendar.getInstance();
        final int year=c.get(Calendar.YEAR);
        final int month=c.get(Calendar.MONTH);
        final int day=c.get(Calendar.DAY_OF_MONTH);
        final int hour=c.get(Calendar.HOUR);
        final int minute=c.get(Calendar.MINUTE);





        db = new Database(this);
       // list2 = (ListView) findViewById(R.id.list2);

        listitem = new ArrayList<String>();



   //  super.onResume();
      //  deleteData();

        bt2 = (Button) findViewById(R.id.delete);

        bt4 = (Button) findViewById(R.id.edit);

        bt1 = (Button) findViewById(R.id.enter);




        e1 = (EditText) findViewById(R.id.name1);
        e2 = (EditText) findViewById(R.id.name2);
        e3 = (EditText) findViewById(R.id.Number);
        e4 = (EditText) findViewById(R.id.place);
        e5 = (EditText) findViewById(R.id.advocacyNumber);
       // e4 = (EditText) findViewById(R.id.type);
        e7 = (TextView) findViewById(R.id.time);
        e8=(TextView) findViewById(R.id.date);


        db.getDate();

       // Toast.makeText(two.this,""+db.getDate(),Toast.LENGTH_LONG).show();


        e7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timepick=new TimePickerDialog(two.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        e7.setText(hourOfDay+":"+minute);

                    }
                },hour,minute,true
                );
                timepick.setTitle("select time");
                timepick .show();

            }
        });


      e8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datepick=new DatePickerDialog(two.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;

                        SimpleDateFormat sdfDate = new SimpleDateFormat("d-MM-yyyy", Locale.ENGLISH);
                        // e8.setText(year+"-"+month+"-"+dayOfMonth);
                        e8.setText(dayOfMonth+"-"+month+"-"+year);

                       // Toast.makeText(galasat.this, "nooooooooooooo" +currentDateandTime, Toast.LENGTH_LONG).show();



                    }
                },year,month,day);
                datepick.setTitle("select date");
                datepick.show();


            }
        });




        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name1 = e1.getText().toString();
                String Name2 = e2.getText().toString();
                String Number = e3.getText().toString();
                String Place = e4.getText().toString();
                String Advorcenumber = e5.getText().toString();
               // String Type=String.valueOf(sp.getText());
                String Type=String.valueOf(sp.getText());
               // String Place = e5.getText().toString();

                String Time = e7.getText().toString();
                String Date = e8.getText().toString();

              //  Toast.makeText(two.this, ""+Date, Toast.LENGTH_LONG).show();


                if (!Name1.equals("") && !Name2.equals("")) {


                    boolean result = db.insertData2(Name1,Name2 , Number, Type, Place, Advorcenumber, Time,Date);
                    Toast.makeText(two.this, "تم تسجيل البيانات بنجاح", Toast.LENGTH_LONG).show();
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    e5.setText("");
//                    e6.setText("");
                    e7.setText("");
                    e8.setText("");

                    listitem.clear();
                   // showdata();


                } else {
                    Toast.makeText(two.this, "لم يتم تسجيل البيانات", Toast.LENGTH_LONG).show();

                }

            }
        });




    }


  /*  public void showdata() {
        Cursor res = db.getAllrecord2();
        //ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listdata);

        //list.setAdapter(adapter);
        if (res.getCount() == 0) {
            Toast.makeText(two.this, "no data", Toast.LENGTH_LONG).show();

        } else {

            while (res.moveToNext()) {
                String t1 = res.getString(0);
                String t2 = res.getString(1);
                String t3 = res.getString(2);
                String t4 = res.getString(3);
                String t5 = res.getString(4);
                String t6 = res.getString(5);

                listitem.add(t1 + " : الاسم : " + t2 + "   ||  نوع القضية : " + t4 + "               ");

                //   Log.v("t1       ,", t1);
            }
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listitem);

            list2.setAdapter(adapter);


        }


    }*/


}