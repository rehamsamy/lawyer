package com.hpmcor.legal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hpmcor.legal.R;

import java.util.List;

public class PeopleAdapter extends ArrayAdapter<Word> {


    private static final String LOG_TAG = WordAdaptar.class.getSimpleName();


    public PeopleAdapter(Context context, List<Word> words ) {
        super(context, 0, words);

    }



    @Override
    public View getView(int position, View convert, ViewGroup parent) {
        View listitem= convert;
        if(listitem ==null){

            listitem= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);


        }


        Word curr=getItem(position);
        TextView num=(TextView) listitem.findViewById(R.id.number);

        num.setText(curr.getMnumber());

        TextView nam1=(TextView) listitem.findViewById(R.id.name1);


        nam1.setText(curr.getMname1());



        TextView nam2=(TextView) listitem.findViewById(R.id.name2);

        nam2.setText(curr.getMname2());

        TextView typ=(TextView) listitem.findViewById(R.id.type);

        typ.setText(curr.getMtype());


        TextView from=(TextView) listitem.findViewById(R.id.from);

        typ.setText(curr.getMfrom());




        ImageView iconView = (ImageView) listitem.findViewById(R.id.image);

        iconView.setImageResource(curr.getMresourc());



        return listitem;









    }



}

