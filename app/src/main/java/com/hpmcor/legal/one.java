package com.hpmcor.legal;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.hpmcor.legal.R;

import java.util.ArrayList;

public class one extends AppCompatActivity {

    Button bt1,bt2;

    GridView list;
   ArrayList<Word> words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        bt1=(Button) findViewById(R.id.sendmail);
        bt2=(Button) findViewById(R.id.share);

         words=new ArrayList<Word>();

        words.add(new Word("قضية جديدة " ,R.drawable.auctio));
        words.add(new Word("توكيل جديد " ,R.drawable.user));
        words.add(new Word("دليل التليفونات " ,R.drawable.call));
        words.add(new Word("المكتب اليوم " ,R.drawable.work));
         words.add(new Word("قضايا المكتب " ,R.drawable.law));
        words.add(new Word("الموكلين" ,R.drawable.alwy));
        words.add(new Word("جميع الجلسات" ,R.drawable.worker));

        words.add(new Word("القوانين الهامة" ,R.drawable.collaboration));
        words.add(new Word("الخروج " ,R.drawable.logout));

       list=(GridView) findViewById(R.id.list);

        WordAdaptar adapter=new WordAdaptar(this,words);
        list.setAdapter(adapter);





        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                // WordAdaptar entry= (WordAdaptar) parent.getAdapter().getItem(position);

                if(position==0){
                    Intent intent=new Intent(one.this,adaya.class);
                    startActivity(intent);
                }

               if(position==1){
                    Intent intent=new Intent(one.this,newm.class);
                    startActivity(intent);
                }

                if(position==2){
                    Intent intent=new Intent(one.this,telephoneNumbers.class);
                    startActivity(intent);

                }

                if(position==3){
                    Intent intent=new Intent(one.this,galasat.class);
                    startActivity(intent);

                }

                if(position==4){
                    Intent intent=new Intent(one.this,adayaviewcontent.class);
                    startActivity(intent);

                }


                if(position==5){
                    Intent intent=new Intent(one.this,tawkeel.class);
                    startActivity(intent);

                }
                if(position==6){
                    Intent intent=new Intent(one.this,calender.class);
                    startActivity(intent);

                }



                if(position==7){
                    Intent intent=new Intent(one.this,lawes.class);
                    startActivity(intent);

                }



                if(position==8){
                 // finish();

                    finishAffinity();
                    System.exit(0);

                  //  System.exit(0);

                }


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu,menu);

         MenuItem searchitem = menu.findItem(R.id.itemsearch);
        searchitem.setVisible(false);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        if(item.getItemId()==R.id.now){

            Intent intent =new Intent(one.this,galasat.class);
            startActivity(intent);

        }
        if(item.getItemId()==R.id.new1){
            Intent intent =new Intent(one.this,three.class);
            startActivity(intent);



        }

        if(item.getItemId()==R.id.new2){

            Intent intent =new Intent(one.this,two.class);
            startActivity(intent);

        }

        if(item.getItemId()==R.id.logout){

            finish();

        }



        return true;
    }

}
