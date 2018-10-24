
package com.hpmcor.legal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hpmcor.legal.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

  //  Button bt=(Button ) findViewById(R.id.enter);

    AdView ad;

    Button bt1,bt2;
    Intent shareintent;
    String sharebody="this is agreat app";

    private InterstitialAd mInterstitialAd;

int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button)findViewById(R.id.sendmail);
        Button bt=(Button ) findViewById(R.id.enter);

        Button bt2=(Button ) findViewById(R.id.share);







        MobileAds.initialize(this,"ca-app-pub-5176080920659538~9687919738");



       // ad.setAdSize(AdSize.BANNER);
        ad=(AdView)findViewById(R.id.adView);

       // AdView adView = new AdView(this);

       // ad.setAdUnitId("ca-app-pub-3940256099942544/6300978111");


        AdRequest adRequest=new AdRequest.Builder().build();

        ad.loadAd(adRequest);

        ad.setVisibility(View.VISIBLE);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                request();
            }

        });

        request();



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,one.class);
                startActivity(intent);

            }
        });


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "اضف اقتراحك" );
                i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(i, "اضافة شكوي أو اقتراح..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }


            }
        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, "نعم انه برنامج رائع");
                startActivity(Intent.createChooser(share, "مشاركة التطبيق..."));

            }
        });





    }
/*
     @Override
  public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem share=(MenuItem) menu.findItem(R.id.share);

        ShareActionProvider actionProvider=(ShareActionProvider) share.getActionProvider();


         Intent shareintent = new Intent(Intent.ACTION_SEND);
         shareintent.setType("text/plain");
         shareintent.putExtra(Intent.EXTRA_TEXT, "نعم انه برنامج رائع");
         startActivity(Intent.createChooser(shareintent, "Share Text"));
        actionProvider.setShareIntent(shareintent);



        return true;
*/




public  void show(View v){

    if(mInterstitialAd.isLoaded()){
        mInterstitialAd.show();
    }

}


public void request(){
    AdRequest adRequest=new AdRequest.Builder().addTestDevice("").build();
    mInterstitialAd.loadAd(adRequest);
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

        if(item.getItemId()==R.id.day){

          Intent intent =new Intent(MainActivity.this,galasat.class);
          startActivity(intent);

        }
        if(item.getItemId()==R.id.new1){
            Intent intent =new Intent(MainActivity.this,three.class);
            startActivity(intent);



        }

        if(item.getItemId()==R.id.new2){

            Intent intent =new Intent(MainActivity.this,two.class);
            startActivity(intent);

        }

        if(item.getItemId()==R.id.logout){

            finish();

        }



        return true;
    }




}

