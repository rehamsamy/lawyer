package com.hpmcor.legal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hpmcor.legal.R;

import java.util.Calendar;

public class view2 extends AppCompatActivity {

   TextView number,name1,name2,type,place,advorcenumber,time,date;

    ImageView img;
    Database db;

    Button bt,bt1;
    EditText e1;


    String num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);




        final Calendar c=Calendar.getInstance();
        final int year=c.get(Calendar.YEAR);
        final int month=c.get(Calendar.MONTH);
        final int day=c.get(Calendar.DAY_OF_MONTH);
        final int hour=c.get(Calendar.HOUR);
        final int minute=c.get(Calendar.MINUTE);



        bt1 = (Button) findViewById(R.id.update);
        e1 = (EditText) findViewById(R.id.id);


        db = new Database(this);

        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView) findViewById(R.id.name2);
        number = (TextView) findViewById(R.id.number);
        type = (TextView) findViewById(R.id.type);
        place = (TextView) findViewById(R.id.place);
        advorcenumber = (TextView) findViewById(R.id.advocacyNumber);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);

        img = (ImageView) findViewById(R.id.image);


        bt = (Button) findViewById(R.id.delete);

        Intent intent = getIntent();


        // Toast.makeText(this,":"+num,Toast.LENGTH_LONG).show();

        String nam1 = intent.getStringExtra("id1");
        name1.setText(nam1);

        String nam2 = intent.getStringExtra("id2");
        name2.setText(nam2);
        num = intent.getStringExtra("id3");
        number.setText(num);
        //e1.setText(num);
        // Toast.makeText(this,""+num,Toast.LENGTH_LONG).show();

        String typ = intent.getStringExtra("id4");
        type.setText(typ);

        final String place1 = intent.getStringExtra("id5");
        place.setText(place1);

        String advorcenum = intent.getStringExtra("id6");
        advorcenumber.setText(advorcenum);

        final String date1 = intent.getStringExtra("id7");
        date.setText(date1);


        final String time1 = intent.getStringExtra("id8");
        time.setText(time1);


        img.setImageResource(intent.getIntExtra("id9", 0));

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(view2.this);
                dialog.setCancelable(false);
                dialog.setTitle("تحذير!!");
                dialog.setMessage("هل انت متاكد من حذف محتويات هذه القضية?");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        String ID = number.getText().toString();
                        Integer result = db.delete2(ID);

                        if (result > 0) {
                            Toast.makeText(view2.this, "تم حذف القضية رقم :" + ID, Toast.LENGTH_LONG).show();
                            name1.setText("");
                            name2.setText("");
                            number.setText("");
                            place.setText("");
                            advorcenumber.setText("");
                            date.setText("");
                            time.setText("");
                            type.setText("");


                        } else {
                            Toast.makeText(view2.this, "لا توجد بيانات ", Toast.LENGTH_LONG).show();
                        }

                        Intent intent = new Intent(view2.this, adaya.class);
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





        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(view2.this,viewcontent2.class);
                String nam1 = name1.getText().toString();
                String nam2 = name2.getText().toString();
                String num =  number.getText().toString();
                String typ =  type.getText().toString();
                String place1 =  place.getText().toString();
                String advoceNum =  advorcenumber.getText().toString();
                String date1 =  date.getText().toString();
                String time1 =  time.getText().toString();
               // int img  =  tx1.getText().toString();


                intent.putExtra("id1",nam1);
                intent.putExtra("id2",nam2);
                intent.putExtra("id3",num);
                intent.putExtra("id4",typ);
                intent.putExtra("id5",place1);
                intent.putExtra("id6",advoceNum);
                intent.putExtra("id7",date1);
                intent.putExtra("id8",time1);
               // intent.putExtra("id9",img);

                startActivity(intent);






            }
        });
//            tx7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TimePickerDialog timepick=new TimePickerDialog(view2.this, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                        tx7.setText(hourOfDay+":"+minute);
//
//                    }
//                },hour,minute,true
//                );
//                timepick.setTitle("select time");
//                timepick.show();
//
//            }
//        });
//
//
//        tx8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DatePickerDialog datepick=new DatePickerDialog(view2.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
