package com.hpmcor.legal;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.hpmcor.legal.R;

import java.util.Calendar;

public class update extends AppCompatActivity {

    Database db;


    three th=new three();

    Button bt1;
    EditText e1,e2,e4,e5,e6;
    TextView e7,e8,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final Calendar c=Calendar.getInstance();
        final int year=c.get(Calendar.YEAR);
        final int month=c.get(Calendar.MONTH);
        final int day=c.get(Calendar.DAY_OF_MONTH);
        final int hour=c.get(Calendar.HOUR);
        final int minute=c.get(Calendar.MINUTE);


        db=new Database(this);

        bt1 = (Button) findViewById(R.id.update);


        e1 = (EditText) findViewById(R.id.name1);
        e2 = (EditText) findViewById(R.id.name2);
        e3 = (TextView) findViewById(R.id.Number);
        e4 = (EditText) findViewById(R.id.type);
        e5=(EditText)findViewById(R.id.place);
        e6 = (EditText) findViewById(R.id.advocacyNumber);
        e7 = (TextView) findViewById(R.id.time);
        e8 = (TextView) findViewById(R.id.date);



        Intent intent = getIntent();
        String nam1 = intent.getStringExtra("id1");

        e3.setText(nam1);

        Cursor res=db.getRecord2(nam1);

        if( res != null && res.moveToFirst() ) {
            e1.setText(res.getString(1));
            e2.setText(res.getString(2));
            e4.setText(res.getString(4));
            e5.setText(res.getString(5));
            e6.setText(res.getString(6));
            e7.setText(res.getString(7));
            e8.setText(res.getString(8));
            Toast.makeText(update.this,""+e1.getText().toString(),Toast.LENGTH_LONG).show();

        }

        Toast.makeText(update.this,""+e1.getText().toString(),Toast.LENGTH_LONG).show();

    /*    bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name1=e1.getText().toString();
                String Name2=e2.getText().toString();
                String id=e3.getText().toString();
                String Type=e4.getText().toString();
                String Place=e5.getText().toString();
                String AdvorceNumber=e6.getText().toString();
                String Time=e7.getText().toString();
                String Date=e8.getText().toString();
                if(!id.equals("")){

                    boolean result= db.updateData2(Name1,Name2,id,Type,Place,AdvorceNumber,Time,Date);

                    Toast.makeText(update.this,"تم تعديل  البيانات بنجاح",Toast.LENGTH_LONG).show();

                   // Toast.makeText(update.this,""+e1.getText().toString(),Toast.LENGTH_LONG).show();


                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    e5.setText("");
                    e6.setText("");
                    e7.setText("");
                    e8.setText("");
                    //listitem.clear();
                    // th. showdata();


                }
                else {
                    Toast.makeText(update.this,"لم يتم تسجيل البيانات",Toast.LENGTH_LONG).show();

                }

            }
        });   */



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(update.this);
                dialog.setCancelable(false);
                dialog.setTitle("تحذير!!");
                dialog.setMessage("هل انت متاكد من تعديل محتويات هذه القضية?" );
                dialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        String Name1=e1.getText().toString();
                        String Name2=e2.getText().toString();
                        String idd=e3.getText().toString();
                        String Type=e4.getText().toString();
                        String Place=e5.getText().toString();
                        String AdvorceNumber=e6.getText().toString();
                        String Time=e7.getText().toString();
                        String Date=e8.getText().toString();

                        if(!idd.equals("")){

                            boolean result= db.updateData2(Name1,Name2,idd,Type,Place,AdvorceNumber,Time,Date);

                            Toast.makeText(update.this,"تم تعديل  البيانات بنجاح",Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(update.this, "لا توجد بيانات ", Toast.LENGTH_LONG).show();
                        }

                        Intent intent=new Intent(update.this,adaya.class);
                        startActivity(intent);

                    }
                })
                        .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Action for "Cancel".
                            }
                        });

                final AlertDialog alert = dialog.create();
                alert.show();

            }
        });











        e7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timepick=new TimePickerDialog(update.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        e7.setText(hourOfDay+":"+minute);

                    }
                },hour,minute,true
                );
                timepick.setTitle("select time");
                timepick.show();

            }
        });


        e8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datepick=new DatePickerDialog(update.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        e8.setText(year+"-"+month+"-"+dayOfMonth);

                    }
                },year,month,day);
                datepick.setTitle("select date");
                datepick.show();


            }
        });





    }

}
