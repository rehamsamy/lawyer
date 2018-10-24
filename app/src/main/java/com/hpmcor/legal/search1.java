package com.hpmcor.legal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hpmcor.legal.R;

import java.util.ArrayList;

public class search1 extends AppCompatActivity {



    ListView list;

    three th;
    Database db;


    ArrayList<String> listitem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search1);

        db = new Database(this);
       // Button bt = (Button) findViewById(R.id.add);


        listitem = new ArrayList<String>();

        list = (ListView) findViewById(R.id.listt);
       // showdata();





    }



  /*  public void showdata() {
        Cursor res = db.getAllrecord();
        //ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listdata);

        //list.setAdapter(adapter);
        if (res.getCount() == 0) {
            Toast.makeText(search1.this, "no data", Toast.LENGTH_LONG).show();

        } else {
            while (res.moveToNext()) {
                String t1 = res.getString(0);
                String t2 = res.getString(1);
                String t3 = res.getString(2);
                String t4 = res.getString(3);
                String t5 = res.getString(4);
                String t6 = res.getString(5);

                listitem.add( t2 );

                //   Log.v("t1       ,", t1);
            }
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listitem);

            list.setAdapter(adapter);


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        MenuItem searchitem=menu.findItem(R.id.itemsearch);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(searchitem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> userslist=new ArrayList<>();

                for(String user:listitem){
                    if(user.toLowerCase().contains(newText.toLowerCase())){
                        userslist.add(user);
                    }

                }
                ArrayAdapter<String> adapter1=new ArrayAdapter<String>(search1.this,android.R.layout.simple_list_item_1,userslist);
                list.setAdapter(adapter1);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    } */
}
