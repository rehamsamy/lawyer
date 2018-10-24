package com.hpmcor.legal;

public class Word {

    public String mtext;
    public int mresource;

    public String mname1;
    public String mname2;
    public String mtype;
    public String mnumber;
    public String mfrom;
    public int mresourc;


    public String aname1;
    public String aname2;
    public String anumber;
    public String atype;

    public String aplace;
    public String ajudgenum;
    public String adate;
    public String atime;
    public int aresourc;


    public Word(String number, String name1, String name2, String type, int resourc) {

        mname1 = name1;
        mname2 = name2;
        mnumber = number;
        mtype = type;
        mresourc = resourc;

    }





    public Word(String name1, String name2, String number, String type, String place, String judgenum,  String time,String date, int resourc) {

        aname1 = name1;
        aname2 = name2;
        anumber = number;
        atype = type;
        aplace=place;
        ajudgenum = judgenum;
        adate = date;
        atime = time;

        aresourc = resourc;


    }


    public Word(String number, String name1, String name2, String type, String from, int resourc) {

        mname1 = name1;
        mname2 = name2;
        mnumber = number;
        mtype = type;
        mfrom = from;
        mresourc = resourc;


    }


    public Word(String text, int resource) {

        mresource = resource;
        mtext = text;

    }

    public Word( String name1,String date, String time) {

        aname1=name1;
        adate = date;
        atime = time;



    }



    public String getMtext() {
        return mtext;
    }

    public int getMresource() {
        return mresource;
    }


    public String getMname1() {
        return mname1;
    }

    public String getMname2() {
        return mname2;
    }

    public String getMnumber() {
        return mnumber;
    }

    public String getMtype() {
        return mtype;
    }

    public String getMfrom() {
        return mfrom;
    }

    public int getMresourc() {
        return mresourc;
    }

    ///////////////////////////////////


    public String getAname1() {
        return aname1;
    }

    public String getAname2() {
        return aname2;
    }

    public String getAnumber() {
        return anumber;
    }

    public String getAtype() {
        return atype;
    }

    public String getAjudgenum() {
        return ajudgenum;
    }

    public String getAplace() {
        return aplace;
    }

    public String getAdate() {
        return adate;
    }
    public String getAtime() {
        return atime;
    }
    public int getAresourc() {
        return aresourc;
    }



}