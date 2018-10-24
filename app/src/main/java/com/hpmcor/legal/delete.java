package com.hpmcor.legal;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hpmcor.legal.R;

public class delete extends AppCompatActivity {

    android.widget.Button bt;
    android.widget.EditText e1;
    Database db;

    //three th = new three();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        db = new Database(this);
        bt = (android.widget.Button) findViewById(R.id.delete);
        e1 = (android.widget.EditText) findViewById(R.id.id);
        //deleteData();


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(delete.this);
                dialog.setCancelable(false);
                dialog.setTitle("تحذير!!");
                dialog.setMessage("هل انت متاكد من حذف محتويات هذه القضية?" );
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        String ID = e1.getText().toString();
                        Integer result = db.delete2(ID);

                        if (result > 0) {
                            Toast.makeText(delete.this, "تم حذف القضية رقم :"+ID , Toast.LENGTH_LONG).show();


                        } else {
                            Toast.makeText(delete.this, "لا توجد بيانات ", Toast.LENGTH_LONG).show();
                        }

                        Intent intent=new Intent(delete.this,adaya.class);
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