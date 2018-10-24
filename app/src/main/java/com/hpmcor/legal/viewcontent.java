package com.hpmcor.legal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hpmcor.legal.R;

import java.util.ArrayList;

public class viewcontent extends AppCompatActivity {

    TextView tx1;
    EditText tx2,tx3,tx4,tx5;

    ImageView img;
    Database db;
Button bt,bt1;

    ArrayList<String> listitem;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcontent);

        bt=(Button) findViewById(R.id.delete);
        bt1=(Button) findViewById(R.id.update);

        db = new Database(this);

        tx1=(TextView) findViewById(R.id.number);
        tx2=(EditText) findViewById(R.id.name1);
        tx3=(EditText) findViewById(R.id.name2);
        tx4=(EditText) findViewById(R.id.type);
        tx5=(EditText) findViewById(R.id.from);
        img=(ImageView) findViewById(R.id.image) ;

        Intent intent = getIntent();
        String num = intent.getStringExtra("id1");
        tx1.setText(num);
        String nam2 = intent.getStringExtra("id3");
        tx3.setText(nam2);
        String nam1 = intent.getStringExtra("id2");
        tx2.setText(nam1);
        String typ = intent.getStringExtra("id4");
        tx4.setText(typ);
        String from = intent.getStringExtra("id6");
        tx5.setText(from);



      // img.setImageResource(intent.getIntExtra("id5",0));





      bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(viewcontent.this);
                dialog.setCancelable(false);
                dialog.setTitle("تحذير!!");
               setTitleColor(24345);
                dialog.setMessage("هل انت متاكد من حذف محتويات هذه التوكيل?" );
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        String ID = tx1.getText().toString();
                        Integer result = db.delete(ID);

                        if (result > 0) {

                            Toast.makeText(viewcontent.this, "تم حذف التوكيل رقم :"+ID , Toast.LENGTH_LONG).show();


                        } else {
                            Toast.makeText(viewcontent.this, "لا توجد بيانات ", Toast.LENGTH_LONG).show();
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

                AlertDialog.Builder dialog = new AlertDialog.Builder(viewcontent.this);
                dialog.setCancelable(false);
                dialog.setTitle("تحذير!!");
                dialog.setMessage("هل انت متاكد من تعديل محتويات هذا التوكيل?" );
                dialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        String idd=tx1.getText().toString();
                        String Name1=tx2.getText().toString();
                        String Name2=tx3.getText().toString();
                        String Type=tx4.getText().toString();
                        String Place=tx5.getText().toString();

                        if(!idd.equals("")){

                            boolean result= db.updateData(idd,Name1,Name2,Type,Place);

                            Toast.makeText(viewcontent.this,"تم تعديل  البيانات بنجاح",Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(viewcontent.this, "لا توجد بيانات ", Toast.LENGTH_LONG).show();
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








    }



}
