package com.hpmcor.legal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class contents extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);
text=(TextView) findViewById(R.id.text);

        Intent intent = getIntent();

        String nam1 = intent.getStringExtra("id");
       text.setText(nam1);


    }
}
