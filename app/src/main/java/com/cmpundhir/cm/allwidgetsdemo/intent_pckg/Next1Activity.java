package com.cmpundhir.cm.allwidgetsdemo.intent_pckg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.cmpundhir.cm.allwidgetsdemo.R;

public class Next1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next1);
        String parcel = getIntent().getStringExtra("pubg");
        Toast.makeText(this, parcel, Toast.LENGTH_SHORT).show();
    }
}
