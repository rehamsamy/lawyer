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

public class WordAdaptAdaya extends ArrayAdapter<Word>{

    private static final String LOG_TAG = Wordadapt.class.getSimpleName();


    public  WordAdaptAdaya(Context context, List<Word> listitem  ) {
        super(context, 0, listitem);

    }


    @Override
    public View getView(int position, View convert, ViewGroup parent) {


        View listitem= convert;

        if(listitem ==null){

            listitem= LayoutInflater.from(getContext()).inflate(R.layout.tawlist_item,parent,false);


        }

           Word curr=getItem(position);
        TextView num=(TextView) listitem.findViewById(R.id.number);

        num.setText(curr.getAnumber());

        TextView nam1=(TextView) listitem.findViewById(R.id.name1);

        nam1.setText(curr.getAname1());

        TextView nam2=(TextView) listitem.findViewById(R.id.name2);

        nam2.setText(curr.getAname2());

        TextView typ=(TextView) listitem.findViewById(R.id.type);

        typ.setText(curr.getAtype());


      //  TextView date=(TextView) listitem.findViewById(R.id.date);

      //  date.setText(curr.getAdate());


        TextView place=(TextView) listitem.findViewById(R.id.place);

        place.setText(curr.getAplace());

        TextView time=(TextView) listitem.findViewById(R.id.time);

        time.setText(curr.getAtime());

        TextView judgenum=(TextView) listitem.findViewById(R.id.advorceNumber);

        judgenum.setText(curr.getAjudgenum());


        ImageView iconView = (ImageView) listitem.findViewById(R.id.image);

        iconView.setImageResource(curr.getAresourc());



        return listitem;

    }


}
