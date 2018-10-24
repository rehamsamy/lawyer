package com.hpmcor.legal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hpmcor.legal.R;

public class delete1 extends AppCompatActivity {
    Button bt;
    EditText e1;
    Database db;
    three th = new three();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete1);
        db = new Database(this);

        bt = (Button) findViewById(R.id.delete1);
        e1 = (EditText) findViewById(R.id.id);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(delete1.this);
                dialog.setCancelable(false);
                dialog.setTitle("تحذير!!");
                setTitleColor(24345);
                dialog.setMessage("هل انت متاكد من حذف محتويات هذه التوكيل?");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        String ID = e1.getText().toString();
                        Integer result = db.delete(ID);

                        if (result > 0) {

                            Toast.makeText(delete1.this, "تم حذف التوكيل رقم :" + ID, Toast.LENGTH_LONG).show();
                            e1.setText("");


                        } else {
                            Toast.makeText(delete1.this, "لا توجد بيانات ", Toast.LENGTH_LONG).show();
                        }

                        Intent intent = new Intent(delete1.this, newm.class);
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

    public void deleteData() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = e1.getText().toString();
                Integer result = db.delete(ID);
                if (result > 0) {
                    Toast.makeText(delete1.this, "تم حذف التوكيل رقم :" + ID, Toast.LENGTH_LONG).show();
                    e1.setText(" ");

                    //showdata();

                } else {
                    Toast.makeText(delete1.this, "من فضلك ادخل رقم التوكيل", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
