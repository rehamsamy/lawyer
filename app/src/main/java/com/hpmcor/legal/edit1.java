package com.hpmcor.legal;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hpmcor.legal.R;

public class edit1 extends AppCompatActivity {
    Database db;


    three th=new three();

    Button bt1;
    EditText e2,e3,e4,e5,e6;
    TextView e1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit1);


        db=new Database(this);

        bt1 = (Button) findViewById(R.id.update);

        e1 = (TextView) findViewById(R.id.number);
        e2 = (EditText) findViewById(R.id.name);
        e3 = (EditText) findViewById(R.id.adress);
        e4 = (EditText) findViewById(R.id.type);
        e5 = (EditText) findViewById(R.id.from);

        Intent intent = getIntent();
        String nam1 = intent.getStringExtra("id1");

        e1.setText(nam1);

        Cursor res=db.getRecord(nam1);

        if( res != null && res.moveToFirst() ) {
            e2.setText(res.getString(2));
            e3.setText(res.getString(3));
            e4.setText(res.getString(4));
            e5.setText(res.getString(5));
            // e2.setText( res.getString(1));

        }




        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Number=e1.getText().toString();
                String Name=e2.getText().toString();
                String Adress=e3.getText().toString();
                String Type=e4.getText().toString();
                String From=e5.getText().toString();




                //String Id=e6.getText().toString();
                boolean result= db.updateData(Number,Name,Adress,Type,From);

                if(!Number.equals("")){

                    Toast.makeText(edit1.this,"تم تعديل  البيانات بنجاح",Toast.LENGTH_LONG).show();
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    e5.setText("");
                    //listitem.clear();
                   // th. showdata();


                }
                else {
                    Toast.makeText(edit1.this,"لم يتم تسجيل البيانات",Toast.LENGTH_LONG).show();

                }

            }
        });




        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(edit1.this);
                dialog.setCancelable(false);
                dialog.setTitle("تحذير!!");
                dialog.setMessage("هل انت متاكد من تعديل محتويات هذا التوكيل?" );
                dialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)


                   // Cursor res=db.getRecord(idd);
                  //  String id1=res.getString(1);
                     //   if(id1 != null) {


                  //  }
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        String idd=e1.getText().toString();
                        String Name1=e2.getText().toString();
                        String Name2=e3.getText().toString();
                        String Type=e4.getText().toString();
                        String Place=e5.getText().toString();


                            if(!idd.equals("")){

                                boolean result= db.updateData(idd,Name1,Name2,Type,Place);

                                Toast.makeText(edit1.this,"تم تعديل  البيانات بنجاح",Toast.LENGTH_LONG).show();

                            } else {
                                Toast.makeText(edit1.this, "لا توجد بيانات ", Toast.LENGTH_LONG).show();
                            }

                            Intent intent=new Intent(edit1.this,newm.class);
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







    }



}
