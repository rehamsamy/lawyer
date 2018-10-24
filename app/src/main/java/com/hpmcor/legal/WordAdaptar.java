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

public class WordAdaptar extends ArrayAdapter<Word> {


    private static final String LOG_TAG = WordAdaptar.class.getSimpleName();


    public  WordAdaptar(one context, List<Word> words ) {
        super((Context) context, 0, words);

    }



    @Override
    public View getView(int position, View convert, ViewGroup parent) {
        View listitem= convert;
        if(listitem ==null){

            listitem= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);


        }
        Word current=getItem(position);

        TextView mag=(TextView) listitem.findViewById(R.id.text);

        mag.setText(current.getMtext());

        ImageView iconView = (ImageView) listitem.findViewById(R.id.image);

        iconView.setImageResource(current.getMresource());

        return listitem;






    }



}

