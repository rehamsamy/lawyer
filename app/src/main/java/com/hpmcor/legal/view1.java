package com.hpmcor.legal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hpmcor.legal.R;

import java.util.ArrayList;

public class view1 extends AppCompatActivity {

    TextView tx1;
    TextView tx2,tx3,tx4,tx5;

    ImageView img;
    Database db;
    Button bt,bt1;

    ArrayList<String> listitem;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view1);

        bt=(Button) findViewById(R.id.delete);
        bt1=(Button) findViewById(R.id.update);

        db = new Database(this);

        tx1=(TextView) findViewById(R.id.number);
        tx2=(TextView) findViewById(R.id.name1);
        tx3=(TextView) findViewById(R.id.name2);
        tx4=(TextView) findViewById(R.id.type);
        tx5=(TextView) findViewById(R.id.from);
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



        img.setImageResource(intent.getIntExtra("id5",0));





        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(view1.this);
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

                            Toast.makeText(view1.this, "تم حذف التوكيل رقم :"+ID , Toast.LENGTH_LONG).show();


                        } else {
                            Toast.makeText(view1.this, "لا توجد بيانات ", Toast.LENGTH_LONG).show();
                        }

                        Intent intent=new Intent(view1.this,newm.class);
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

                Intent intent=new Intent(view1.this,viewcontent.class);
                String num =tx1.getText().toString();
                String nam1 = tx2.getText().toString();
                String nam2 = tx3.getText().toString();
                String typ = tx4.getText().toString();
                String from = tx5.getText().toString();
              //  ImageView img=img.getImage



                intent.putExtra("id1",num);
                intent.putExtra("id2",nam1);
                intent.putExtra("id3",nam2);
                intent.putExtra("id4",typ);
               // intent.putExtra("id5",img);
                intent.putExtra("id6",from);

                startActivity(intent);

            }
        });








    }



}
