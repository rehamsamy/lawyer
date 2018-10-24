package com.hpmcor.legal;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.hpmcor.legal.R;

import java.util.Calendar;

public class viewcontent2 extends AppCompatActivity {

    EditText tx1,tx2,tx4,tx5,tx6;
            TextView tx7,tx8,tx3;


    ImageView img;
    Database db;

Button bt,bt1;
EditText e1;


    String num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcontent2);




        final Calendar c=Calendar.getInstance();
        final int year=c.get(Calendar.YEAR);
        final int month=c.get(Calendar.MONTH);
        final int day=c.get(Calendar.DAY_OF_MONTH);
        final int hour=c.get(Calendar.HOUR);
        final int minute=c.get(Calendar.MINUTE);



        bt1 = (Button) findViewById(R.id.update);
        e1 = (EditText) findViewById(R.id.id);


        db = new Database(this);

        tx1 = (EditText) findViewById(R.id.name1);
        tx2 = (EditText) findViewById(R.id.name2);
        tx3 = (TextView) findViewById(R.id.number);
        tx4 = (EditText) findViewById(R.id.type);
        tx5 = (EditText) findViewById(R.id.place);
        tx6 = (EditText) findViewById(R.id.advocacyNumber);
        tx7 = (TextView) findViewById(R.id.date);
        tx8 = (TextView) findViewById(R.id.time);

        img = (ImageView) findViewById(R.id.image);


        bt = (Button) findViewById(R.id.delete);

        Intent intent = getIntent();


        // Toast.makeText(this,":"+num,Toast.LENGTH_LONG).show();

        String nam1 = intent.getStringExtra("id1");
        tx1.setText(nam1);

        String nam2 = intent.getStringExtra("id2");
        tx2.setText(nam2);
        num = intent.getStringExtra("id3");
        tx3.setText(num);
        //e1.setText(num);
        // Toast.makeText(this,""+num,Toast.LENGTH_LONG).show();

        String typ = intent.getStringExtra("id4");
        tx4.setText(typ);

        String place = intent.getStringExtra("id5");
        tx5.setText(place);

        String advorcenum = intent.getStringExtra("id6");
        tx6.setText(advorcenum);

        String date = intent.getStringExtra("id7");
        tx7.setText(date);


        String time = intent.getStringExtra("id8");
        tx8.setText(time);


      //  img.setImageResource(intent.getIntExtra("id9", 0));

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(viewcontent2.this);
                dialog.setCancelable(false);
                dialog.setTitle("تحذير!!");
                dialog.setMessage("هل انت متاكد من حذف محتويات هذه القضية?");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        String ID = tx3.getText().toString();
                        Integer result = db.delete2(ID);

                        if (result > 0) {
                            Toast.makeText(viewcontent2.this, "تم حذف القضية رقم :" + ID, Toast.LENGTH_LONG).show();
                            tx1.setText("");
                            tx2.setText("");
                            tx3.setText("");
                            tx4.setText("");
                            tx5.setText("");
                            tx6.setText("");
                            tx7.setText("");
                            tx8.setText("");


                        } else {
                            Toast.makeText(viewcontent2.this, "لا توجد بيانات ", Toast.LENGTH_LONG).show();
                        }

                       finish();

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





       bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(viewcontent2.this);
                dialog.setCancelable(false);
                dialog.setTitle("تحذير!!");
                dialog.setMessage("هل انت متاكد من تعديل محتويات هذه القضية?" );
                dialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        String Name1=tx1.getText().toString();
                        String Name2=tx2.getText().toString();
                        String idd=tx3.getText().toString();
                        String Type=tx4.getText().toString();
                        String Place=tx5.getText().toString();
                        String AdvorceNumber=tx6.getText().toString();
                        String Time=tx7.getText().toString();
                        String Date=tx8.getText().toString();
                       // Intent intent1=new Intent(viewcontent2.this,update.class);
                        //startActivity(intent1);

                        if(!idd.equals("")){

                            boolean result= db.updateData2(Name1,Name2,idd,Type,Place,AdvorceNumber,Time,Date);

                            Toast.makeText(viewcontent2.this,"تم تعديل  البيانات بنجاح",Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(viewcontent2.this, "لا توجد بيانات ", Toast.LENGTH_LONG).show();
                        }

//                        Intent intent=new Intent(viewcontent2.this,adaya.class);
//                        startActivity(intent);
                        finish();
                        //finishActivity(view2.CONTEXT_INCLUDE_CODE);
                       // finishActivityFromChild(view2.class,FI);

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

        tx7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timepick=new TimePickerDialog(viewcontent2.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tx7.setText(hourOfDay+":"+minute);

                    }
                },hour,minute,true
                );
                timepick.setTitle("select time");
                timepick.show();

            }
        });


        tx8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datepick=new DatePickerDialog(viewcontent2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tx8.setText(year+"-"+month+"-"+dayOfMonth);

                    }
                },year,month+1,day);
                datepick.setTitle("select date");
                datepick.show();


            }
        });




    }
}
