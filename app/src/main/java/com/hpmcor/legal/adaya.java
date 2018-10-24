package com.hpmcor.legal;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.hpmcor.legal.R;

import java.util.ArrayList;

public class adaya extends AppCompatActivity {

    ListView list;
    Button bt1, bt2, bt4;

    Database db;

    Word word;

    ArrayList<Word> listitem;
    AdayaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaya);

        bt2 = (Button) findViewById(R.id.delete);

        bt4 = (Button) findViewById(R.id.edit);


        adapter=new AdayaAdapter(this,listitem);
        db = new Database(this);
        Button bt = (Button) findViewById(R.id.add);


      //  listitem = new ArrayList<Word>();

        list = (ListView) findViewById(R.id.list);
       // showdata();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(adaya.this, two.class);
                startActivity(intent);


            }
        });



        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(adaya.this, delete.class);

                startActivity(intent);


            }
        });



        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(adaya.this);
                builder.setTitle("ادخل رقم التوكيل:");
                final EditText input = new EditText(adaya.this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String m_Text = input.getText().toString();


                        Intent intent = new Intent(adaya.this, update.class);

                        intent.putExtra("id1",m_Text);
                        startActivity(intent);

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();



            }
        });



                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(adaya.this,view2.class);
                String nam1 = listitem.get(position).getAname1();
                String nam2 = listitem.get(position).getAname2();
                String num = listitem.get(position).getAnumber();
                String typ = listitem.get(position).getAtype();
                String place = listitem.get(position).getAplace();
                String advoceNum = listitem.get(position).getAjudgenum();
                String date = listitem.get(position).getAdate();
                String time = listitem.get(position).getAtime();
                int img  = listitem.get(position).getAresourc();


                intent.putExtra("id1",nam1);
                intent.putExtra("id2",nam2);
                intent.putExtra("id3",num);
                intent.putExtra("id4",typ);
                intent.putExtra("id5",place);
                intent.putExtra("id6",advoceNum);
                intent.putExtra("id7",date);
                intent.putExtra("id8",time);
                intent.putExtra("id9",img);

                startActivity(intent);
            }
        });




    }


    public void showdata() {
        Cursor res2 = db.getAllrecord2();

        listitem=new ArrayList<Word>();
        //ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listdata);

        //list.setAdapter(adapter);
        if (res2==null) {
            Toast.makeText(adaya.this, "no data", Toast.LENGTH_LONG).show();

        } else {
            while (res2.moveToNext()) {


                String t1 = res2.getString(1);
                String t2 = res2.getString(2);
                String t3 = res2.getString(3);
                String t4 = res2.getString(4);
                String t5 = res2.getString(5);
                String t6 = res2.getString(6);
                String t7 = res2.getString(7);
                String t8 = res2.getString(8);
               word=new Word(t1,t2,t3,t4,t5,t6,t7,t8,R.drawable.libra);
                listitem.add(word);



                list = (ListView) findViewById(R.id.list);

                AdayaAdapter adapter=new AdayaAdapter(this,listitem);
                list.setAdapter(adapter);


            }


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.menu, menu);

        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem searchitem = menu.findItem(R.id.itemsearch);

      //  MenuItem searchitem1 = menu.findItem(R.id.setting);



        final android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) searchitem.getActionView();
        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

              ArrayList<Word> userslist=new ArrayList<Word>();

                for(Word user:listitem){
                    //  if(user.toLowerCase().contains(newText.toLowerCase())){
                    if((user.getAname1().toLowerCase().contains(searchView.getQuery().toString().toLowerCase()))
                            ||(user.getAnumber().toLowerCase().contains(searchView.getQuery().toString().toLowerCase()))){

                        userslist.add(user);
                    }

                }
                // Wordadapt adapter=new Wordadapt(this,android.R.layout.simple_list_item_1,userslist);
                AdayaAdapter adapter=new AdayaAdapter(adaya.this,userslist);

                list.setAdapter(adapter);

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