package com.hpmcor.legal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.hpmcor.legal.R;

import java.util.ArrayList;

public class tawkeel extends AppCompatActivity {


    ListView list;
    Database db;
   ArrayList<Word> listitem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tawkeel);

        db = new Database(this);
       // Button bt = (Button) findViewById(R.id.add);

       // final ArrayList<Word> listitem=new ArrayList<Word>();
       listitem = new ArrayList<Word>();
        list = (ListView) findViewById(R.id.list);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(tawkeel.this, view1.class);
                    String num = listitem.get(position).getMnumber();
                    String nam1 = listitem.get(position).getMname1();
                    String nam2 = listitem.get(position).getMname2();
                    String typ = listitem.get(position).getMtype();
                    String from = listitem.get(position).getMfrom();
                    int img = listitem.get(position).getMresourc();


                    intent.putExtra("id1", num);
                    intent.putExtra("id2", nam1);
                    intent.putExtra("id3", nam2);
                    intent.putExtra("id4", typ);
                    intent.putExtra("id5", img);
                    intent.putExtra("id6", from);

                    startActivity(intent);
                }
            });
        }




    public void showdata() {
        Cursor res = db.getAllrecord();
        if (res==null) {
            Toast.makeText(tawkeel.this, "لا توجد بيانات:", Toast.LENGTH_LONG).show();

        } else {
            while (res.moveToNext()) {
                String t1 = res.getString(0);
                String t2 = res.getString(1);
                String t3 = res.getString(2);
                String t4 = res.getString(3);
                String t5 = res.getString(4);
                String t6 = res.getString(5);
                Word word=new Word(t2,t3,t4,t5,t6,R.drawable.tawkel);
                listitem.add(word);

                list = (ListView) findViewById(R.id.list);

                Wordadapt adapter=new Wordadapt(this,listitem);
                list.setAdapter(adapter);

            }

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        final MenuItem searchitem=menu.findItem(R.id.itemsearch);
        final android.support.v7.widget.SearchView searchView=(android.support.v7.widget.SearchView) searchitem.getActionView();

        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Word> userslist=new ArrayList<Word>();


                for(Word user:listitem){
                    //  if(word.getMname1().toLowerCase().contains(searchView.getQuery().toString())|| word.getMname2().toLowerCase().contains(searchView.getQuery().toString())){
                    if((user.getMname1().toLowerCase().contains(searchView.getQuery().toString().toLowerCase()))
                            ||(user.getMnumber().toLowerCase().contains(searchView.getQuery().toString().toLowerCase()))){
                        //  Toast.makeText(getBaseContext(),""+searchView,Toast.LENGTH_LONG).show();

                        userslist.add(user);
                    }

                    WordAdaptTaw adapter=new WordAdaptTaw(tawkeel.this,userslist);
                    list.setAdapter(adapter);
                }
                // Wordadapt adapter=new Wordadapt(this,android.R.layout.simple_list_item_1,userslist);

                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }






    @Override
    protected void onResume() {
        super.onResume();
        showdata();
    }
}
